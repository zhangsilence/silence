package com.lemon.silence.config;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlusConfig配置信息
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/9/19 14:30
 */
@Configuration
@MapperScan({"com.lemon.silence.mybatis"})
public class MybatisPlusConfig {
	/**
	 * 分页插件
	 */
	@Bean
	public PaginationInnerInterceptor paginationInnerInterceptor() {
		return new PaginationInnerInterceptor();
	}
}
