package com.lemon.silence;

import com.lemon.silence.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author silence
 */
@EnableSwagger2
@EnableAsync
@EnableScheduling
//@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
@MapperScan(basePackages = "com.lemon.silence.mybatis.mapper")
public class SilenceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SilenceApplication.class, args);
		log.info(Constants.SWAGGER_ADDRESS);
	}
}
