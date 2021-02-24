package com.lemon.silence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 解决vue发送请求跨域问题
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/9/12 21:40
 */
@Configuration
public class CorsFilterConfig {

	@Bean
	public CorsFilter corsFilter() {
		//添加CORS配置信息
		CorsConfiguration config = new CorsConfiguration();
		//允许的域，如果写成*，无法使用cookie
		config.addAllowedOrigin("*");
		//允许发送cookie信息
		config.setAllowCredentials(true);
		//允许的请求方式
		config.addAllowedMethod("OPTION");
		config.addAllowedMethod("HEAD");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("DELETE");
		//允许的请求头信息
		config.addAllowedHeader("*");
		config.addExposedHeader("Content-Disposition");
		//添加映射路径
		UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
		configSource.registerCorsConfiguration("/**", config);
		//返回配置好的CorsFilter
		return new CorsFilter(configSource);
	}
}
