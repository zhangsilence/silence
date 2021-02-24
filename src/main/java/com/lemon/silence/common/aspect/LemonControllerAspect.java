package com.lemon.silence.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 项目出入参打印切面
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/7/14 15:10
 */
@Component
@Slf4j
@Aspect
public class LemonControllerAspect {

	@Pointcut(value = "execution(* com.lemon.silence.controller..*.*(..))")
	public void controllerPoint() {
	}

	@Before("controllerPoint()")
	public void before(JoinPoint joinPoint) {

		if (ignoreRequest(joinPoint)) {
			return;
		}
		log.info("开始记录");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (attributes == null) {
			log.info("查询不到request信息");
			return;
		}
		HttpServletRequest request = attributes.getRequest();
		log.info("url:{},", request.getRequestURL());
		log.info("方式:{},", request.getMethod());
		log.info("端口号：{}", request.getRemotePort());
		log.info("ip:{},", request.getRemoteAddr());
		log.info("类名:{},", joinPoint.getSignature().getDeclaringTypeName());
		log.info("方法名:{},", joinPoint.getSignature().getName());
		Object[] parameter = joinPoint.getArgs();
		if (parameter != null) {
			for (int i = 0; i <= parameter.length - 1; i++) {
				log.info("方法入参：args{}={}", i + 1, parameter[i]);
			}
		}
	}

	@AfterReturning(pointcut = "controllerPoint()", returning = "object")
	public void doAfterReturn(JoinPoint joinPoint, Object object) {
		if (ignoreRespone(joinPoint)) {
			return;
		}
		log.info("方法出参：{}", object);
		log.info("记录结束");
	}

	private boolean ignoreRequest(JoinPoint joinPoint) {
		IgnoreLog annotation = getIgnoreAnnotation(joinPoint);
		return annotation != null && annotation.ignoreRequest();
	}

	private boolean ignoreRespone(JoinPoint joinPoint) {
		IgnoreLog annotation = getIgnoreAnnotation(joinPoint);
		return annotation != null && annotation.ignoreResponse();
	}

	private IgnoreLog getIgnoreAnnotation(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		return AnnotationUtils.findAnnotation(method, IgnoreLog.class);
	}
}

