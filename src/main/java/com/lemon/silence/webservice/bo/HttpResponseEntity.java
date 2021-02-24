package com.lemon.silence.webservice.bo;

import lombok.Data;

/**
 * 远程访问返回数据对象
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/8/28 13:57
 */
@Data
public class HttpResponseEntity {

	private long length;

	private String content;
}
