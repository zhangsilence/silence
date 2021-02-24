package com.lemon.silence.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

/**
 * 响应实体类
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/7/14 15:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseMessageEntity<T> {

	private String code;

	private String message;

	@Nullable
	private T data;

	public ResponseMessageEntity(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
