package com.lemon.silence.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplateConfig配置信息
 * @author zhangxueqi
 */
@Configuration
public class RestTemplateConfig {

	@Value("${restTemplate.readTimeout}")
	private int readTimeout;

	@Value("${restTemplate.connectTimeout}")
	private int connectTimeout;

	@Bean
	public RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setReadTimeout(readTimeout);
		factory.setConnectTimeout(connectTimeout);
		return new RestTemplate(factory);
	}
}