package com.pytap.project.aspect;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pytap.project.annotation.Log;
import com.pytap.project.dto.ErrorLogDTO;
import com.pytap.project.dto.WebLogDTO;
import com.pytap.project.service.ErrorLogService;
import com.pytap.project.service.WebLogService;
import com.pytap.project.utils.SecurityUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
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
public class LogAspect {

	@Resource
	private WebLogService webLogService;

	@Resource
	private ErrorLogService errorLogService;

	private final ThreadLocal<Long> currentTime = new ThreadLocal<>();

	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Pointcut("@annotation(com.pytap.project.annotation.Log)")
	public void pointCut() {

	}


	@Around("pointCut()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		currentTime.set(System.currentTimeMillis());

		WebLogDTO webLogDTO = new WebLogDTO();

		Object result;

		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		Log log = method.getAnnotation(Log.class);

		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

		if (null != requestAttributes) {
			HttpServletRequest request = requestAttributes.getRequest();
			webLogDTO.setIp(request.getRemoteAddr());
			webLogDTO.setUrl(request.getRequestURI());

			if (request.getParameterMap().size() == 0) {
				webLogDTO.setParam(JSONArray.toJSONString(joinPoint.getArgs()));
			} else {
				webLogDTO.setParam(JSONObject.toJSONString(request.getParameterMap()));
			}

		}

		result = joinPoint.proceed();

		webLogDTO.setMessage(log.value());
		webLogDTO.setMethod(joinPoint.getSignature().getName());

		if (null != result) {
			webLogDTO.setResult(result.toString());
		} else {
			webLogDTO.setResult("void");
		}
		webLogDTO.setUsername(SecurityUtil.getUsername());
		webLogDTO.setCreateTime(new Date().toString());
		webLogDTO.setSpendTime(System.currentTimeMillis() - currentTime.get());

		webLogService.insertWebLog(webLogDTO);

		currentTime.remove();

		return result;

	}

	@AfterThrowing(pointcut = "pointCut()", throwing = "e")
	public void errorLogSave(JoinPoint joinPoint, Throwable e) {

		logger.error(e.getMessage());

		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

		if (null != requestAttributes) {
			HttpServletRequest request = (HttpServletRequest)
					requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
			if (null != request) {
				try {
					ErrorLogDTO errorLog = new ErrorLogDTO();

					MethodSignature signature = (MethodSignature) joinPoint.getSignature();
					Method method = signature.getMethod();

					errorLog.setMethod(method.getName());
					if (request.getParameterMap().size() == 0) {
						errorLog.setParam(JSONArray.toJSONString(joinPoint.getArgs()));
					} else {
						errorLog.setParam(JSONObject.toJSONString(request.getParameterMap()));
					}
					errorLog.setName(e.getClass().getName());
					errorLog.setMessage(stackTraceToString(e.getClass().getName(), e.getMessage(), e.getStackTrace()));
					errorLog.setUsername(SecurityUtil.getUsername());
					errorLog.setUrl(request.getRequestURI());
					errorLog.setIp(request.getRemoteAddr());
					errorLog.setCreateTime(new Date().toString());

					errorLogService.insertErrorLog(errorLog);

				} catch (Exception exception) {
					exception.printStackTrace();
					logger.error(exception.getMessage());
				}
			}

		}

	}

	private String stackTraceToString(String name, String message, StackTraceElement[] elements) {
		StringBuilder builder = new StringBuilder();
	    for (StackTraceElement element : elements) {
		    builder.append(element).append("\n");
	    }
	    return name + ":" + message + "\n\t" + builder.toString();
	}

}
