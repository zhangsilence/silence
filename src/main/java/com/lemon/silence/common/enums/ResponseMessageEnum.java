package com.lemon.silence.common.enums;

import com.lemon.silence.common.Constants;
import lombok.Getter;

/**
 * 响应枚举类
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/7/14 15:10
 */
@Getter
public enum ResponseMessageEnum {

	SUSSCESS("0", "200", "请求执行成功"),

	FAIL("1", "9999", "请求执行失败"),

	VALID_EXCEPTION("1", "9998", "数据校验异常"),

	REMOTE_CALL_EXCEPTION("1", "8000", "远程调用异常");

	private String code;
	private String messageId;
	private String message;


	ResponseMessageEnum(String code, String messageId, String message) {
		this.code = code;
		this.messageId = messageId;
		this.message = message;
	}

	/**
	 * 报错信息打印
	 */
	public String getFullMessage() {
		return this.messageId + Constants.EXCEPTION_SPLIT + this.message;
	}
}
