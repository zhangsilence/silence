package com.lemon.silence.common.exception;

import com.lemon.silence.common.dto.ResponseMessageUntils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 * 兜底异常处理
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/9/19 14:37
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class ExceptionHandler {

	private ResponseEntity<Object> buildResponseRntity(Object entity) {
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}

	/**
	 * 业务自定义异常
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler({BizException.class})
	@ResponseBody
	public ResponseEntity<Object> handleException(BizException e, WebRequest request) {
		if (e.getResponseMessageEnum() != null) {
			return buildResponseRntity(ResponseMessageUntils.fail(e.getResponseMessageEnum()));
		}
		return buildResponseRntity(ResponseMessageUntils.fail(e.getMessage()));
	}

	/**
	 * 兜底异常处理
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
	@ResponseBody
	public ResponseEntity<Object> handleException(Exception e, WebRequest request) {
		log.error("系统内部错误！【内部异常】：{}", e);
		return buildResponseRntity(ResponseMessageUntils.fail());
	}
}
