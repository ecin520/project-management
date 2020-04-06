package com.pytap.project.aspect;

import com.pytap.project.annotation.WebLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * web日志切面
 * @author Ecin520
 * @date 2020/4/7 0:35
 */
@Aspect
@Component
public class WebLogAspect {

	private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

	private ThreadLocal<Long> currentTime = new ThreadLocal<>();

	@Pointcut("@annotation(com.pytap.project.annotation.WebLog)")
	public void pointCut() {

	}

	@Around("pointCut()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result;

		currentTime.set(System.currentTimeMillis());

		result = joinPoint.proceed();


		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		WebLog webLog = method.getAnnotation(WebLog.class);

		logger.info(webLog.value());
		logger.info(joinPoint.getSignature() + "方法执行了" + (System.currentTimeMillis() - currentTime.get()) + "ms");

		currentTime.remove();
		return result;
	}

}
