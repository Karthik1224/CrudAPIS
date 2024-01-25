package com.example.demo.Configurations;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

	@Bean
	public Executor executor()
	{
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		
		//Initialized 2 threads
		taskExecutor.setCorePoolSize(2);
		taskExecutor.setThreadNamePrefix("transactionThread-");
		taskExecutor.initialize();
		return taskExecutor;
	}
}
