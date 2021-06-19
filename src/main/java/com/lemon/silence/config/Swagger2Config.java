package com.lemon.silence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

/**
 * swagger2配置信息
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/7/14 15:10
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
	//1.声明api 文档的属性 构建起
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("私人项目调优")
				.description("请勿传播")
				.termsOfServiceUrl("http://www.baidu.com")
				.contact(new Contact("lemon.com", "www.baidu.com", "zhangxueqi121@163.com"))
				.version("1.0")
				.build();
	}

	//2配置核心配置信息
	@Bean
	public Docket buildDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				//采用指定扫描包的的路径定义
				.apis(RequestHandlerSelectors.basePackage("com.lemon"))
				.build()
				.directModelSubstitute(LocalDate.class, String.class);
	}
}