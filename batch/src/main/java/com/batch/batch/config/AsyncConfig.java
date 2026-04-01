package com.batch.batch.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync // Enables @Async support
public class AsyncConfig {

    @Bean(name = "customTaskExecutor")
    public SimpleAsyncTaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor executor=new SimpleAsyncTaskExecutor();

        executor.setThreadNamePrefix("multiStep");
      //  ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
executor.setConcurrencyLimit(1);
//executor.s
        return executor;
    }
}

