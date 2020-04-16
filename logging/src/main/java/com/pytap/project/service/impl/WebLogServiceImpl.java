package com.pytap.project.service.impl;

import com.pytap.project.dto.WebLogDTO;
import com.pytap.project.service.WebLogService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/4/7 2:21
 */
@Service
public class WebLogServiceImpl implements WebLogService {

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public void insertWebLog(WebLogDTO webLog) {
		redisTemplate.opsForList().leftPush("WebLog", webLog);
	}

	@Override
	public List<WebLogDTO> getWebLogs(WebLogDTO webLogDTO) {
		List<Object> list = redisTemplate.opsForList().range("WebLog", 0, -1);
		if (null == list) {
			return null;
		}
		List<WebLogDTO> result = new ArrayList<>(16);
		if (null != webLogDTO.getUsername()) {
		    for (Object o : list) {
		    	WebLogDTO temp = (WebLogDTO) o;
		    	if (webLogDTO.getUsername().equals(temp.getUsername())) {
		    		result.add(temp);
			    }
		    }
		    return result;
		}
		if (null != webLogDTO.getMethod()) {
			for (Object o : list) {
				WebLogDTO temp = (WebLogDTO) o;
				if (webLogDTO.getMethod().equals(temp.getMethod())) {
					result.add(temp);
				}
			}
			return result;
		}
		return null;
	}

	@Override
	public List<Object> listWebLogs() {
		return redisTemplate.opsForList().range("WebLog", 0, -1);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer deleteAllWebLogs() {
		try {
			redisTemplate.delete("WebLog");
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}


}
