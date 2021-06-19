package com.lemon.silence.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/10/20 14:21
 */
@Configuration
@EnableAsync
public class ThreadConfig implements AsyncConfigurer {

	@Bean
	@Primary
	@Override
	public Executor getAsyncExecutor(){

		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		//核心线程数
		executor.setCorePoolSize(6);
		//最大线程数
		executor.setMaxPoolSize(8);
		//任务队列数
		executor.setQueueCapacity(1000);
		//存活时间
		executor.setKeepAliveSeconds(60);
		//设置阻塞策略
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.initialize();

		return executor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler(){
		return null;
	}
}
