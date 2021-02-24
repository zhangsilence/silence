package com.lemon.silence.utils.remote;

import com.alibaba.fastjson.JSONObject;
import com.lemon.silence.common.exception.BizException;
import com.lemon.silence.common.enums.ResponseMessageEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * springboot自带的restTemplate远程访问方法post
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/9/16 16:26
 */
@Slf4j
@Component
public class RestTemplateUtil {

	@Autowired
	private RestTemplate restTemplate;

	public String getResponseInfo(String url, JSONObject params) {
		long start = System.currentTimeMillis();
		String response = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
			headers.setContentType(type);
			headers.add("Accept", MediaType.APPLICATION_JSON.toString());
			HttpEntity<String> httpEntity = new HttpEntity(params.toJSONString(), headers);
			ResponseEntity responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
			log.info("远程调用成功耗时：{}", System.currentTimeMillis() - start);
			response = responseEntity.getBody().toString();
			log.info("返回数据信息打印：{}", response);
		} catch (Exception e) {
			log.info("远程调用失败耗时：{}", System.currentTimeMillis() - start);
			log.info("远程调用异常：{}", e.getMessage());
			log.info("远程调用URL：{}，参数：{}", url, params.toJSONString());
			throw new BizException(ResponseMessageEnum.REMOTE_CALL_EXCEPTION);
		}
		return response;
	}

}
