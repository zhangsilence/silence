package com.lemon.silence.common.exception;

import com.lemon.silence.common.enums.ResponseMessageEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 业务自定义异常
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/9/16 16:39
 */
@Setter
@Getter
public class BizException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	private ResponseMessageEnum responseMessageEnum;

	public BizException(ResponseMessageEnum responseMessageEnum) {
		super(responseMessageEnum.getCode());
		this.code = responseMessageEnum.getCode();
		this.responseMessageEnum = responseMessageEnum;
		this.message = responseMessageEnum.getMessage();
	}

	public BizException(String message) {
		this.message = message;
	}

}
