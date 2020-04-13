package com.pytap.project.aspect;

import com.pytap.project.annotation.WebLog;
import com.pytap.project.model.WebLogDO;
import com.pytap.project.service.WebLogService;
import com.pytap.project.utils.SecurityUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * web日志切面
 * @author Ecin520
 * @date 2020/4/7 0:35
 */
@Aspect
@Component
public class WebLogAspect {

	private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

	@Resource
	private WebLogService webLogService;

	private ThreadLocal<Long> currentTime = new ThreadLocal<>();

	@Pointcut("@annotation(com.pytap.project.annotation.WebLog)")
	public void pointCut() {

	}

	@Around("pointCut()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		WebLogDO webLogDO = new WebLogDO();

		Object result;

		currentTime.set(System.currentTimeMillis());

		result = joinPoint.proceed();


		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		WebLog webLog = method.getAnnotation(WebLog.class);

		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

		if (null != requestAttributes) {
			HttpServletRequest request = requestAttributes.getRequest();
			webLogDO.setIp(request.getLocalAddr());
			logger.info(request.getLocalAddr());
		}

		webLogDO.setDescription(webLog.value());
		webLogDO.setMethod(joinPoint.getSignature().getName());
		if (null != result) {
			webLogDO.setResult(result.toString());
		} else {
			webLogDO.setResult("void");
		}
		webLogDO.setUsername(SecurityUtil.getUsername());
		webLogDO.setCreateTime(new Date().toString());
		webLogDO.setSpendTime(System.currentTimeMillis() - currentTime.get());
		webLogService.insertWebLog(webLogDO);
		currentTime.remove();
		return result;
	}

}
