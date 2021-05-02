package com.lemon.silence.service;

import com.alibaba.fastjson.JSONObject;
import com.lemon.silence.utils.remote.RestTemplateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * 远程调用服务类
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/8/28 14:06
 */
@Slf4j
@Service
public class RestfulCallService {

	@Autowired
	private RestTemplateUtil restTemplateUtil;

	public String getContentInfo() {
		String url = "http://localhost:8080/lemon/api/user/info";
		JSONObject params = new JSONObject();
		return restTemplateUtil.getResponseInfo(url, HttpMethod.POST, params);
	}

}
