package com.lemon.silence.common.aspect;

import java.lang.annotation.*;

/**
 * 忽略打印注解
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/7/14 15:10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface IgnoreLog {
	/**
	 * 忽略入参打印
	 */
	boolean ignoreRequest() default true;

	/**
	 * 忽略出参打印
	 */
	boolean ignoreResponse() default true;
}
