package com.lemon.silence.common.dto;

import com.lemon.silence.common.enums.ResponseMessageEnum;

/**
 * 响应工具类类
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/7/14 15:10
 */
public class ResponseMessageUntils {

	public static <T> ResponseMessageEntity<T> successs() {
		return successResponse();
	}

	public static <T> ResponseMessageEntity<T> fail() {
		ResponseMessageEntity<T> responseMessageEntity = failResponse();
		return responseMessageEntity;
	}

	public static <T> ResponseMessageEntity<T> successs(T data) {
		ResponseMessageEntity<T> responseMessageEntity = successResponse();
		responseMessageEntity.setData(data);
		successResponse().setData(data);
		return responseMessageEntity;
	}

	public static <T> ResponseMessageEntity<T> fail(T data) {
		ResponseMessageEntity<T> responseMessageEntity = failResponse();
		responseMessageEntity.setData(data);
		return responseMessageEntity;
	}

	public static <T> ResponseMessageEntity<T> fail(String code, String message) {
		return new ResponseMessageEntity<T>(code, message);
	}

	public static <T> ResponseMessageEntity<T> fail(ResponseMessageEnum enums) {
		return new ResponseMessageEntity<T>(enums.getCode(), enums.getFullMessage());
	}

	public static <T> ResponseMessageEntity<T> fail(ResponseMessageEnum enums, T data) {
		return new ResponseMessageEntity<T>(enums.getCode(), enums.getFullMessage(), data);
	}

	public static <T> ResponseMessageEntity<T> successResponse() {
		return new ResponseMessageEntity<T>(ResponseMessageEnum.SUSSCESS.getCode(), ResponseMessageEnum.SUSSCESS.getMessage());
	}

	public static <T> ResponseMessageEntity<T> failResponse() {
		return new ResponseMessageEntity<T>(ResponseMessageEnum.FAIL.getCode(), ResponseMessageEnum.FAIL.getMessage());
	}
}
