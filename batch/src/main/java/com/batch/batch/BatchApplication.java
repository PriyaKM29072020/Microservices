package com.batch.batch;

import com.batch.batch.domain.FeedRecord;
import com.batch.batch.mapper.FeedExcelMapper;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.partition.Partitioner;
import org.springframework.batch.core.partition.support.MultiResourcePartitioner;
import org.springframework.batch.core.partition.support.TaskExecutorPartitionHandler;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.extensions.excel.poi.PoiItemReader;
import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.batch.infrastructure.repeat.interceptor.RepeatOperationsInterceptor;
import org.springframework.batch.infrastructure.repeat.policy.SimpleCompletionPolicy;
import org.springframework.batch.infrastructure.repeat.support.RepeatTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableBatchProcessing
public class BatchApplication {

    public BatchApplication(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }

    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }

    @Autowired
    ItemWriter itemWriter;
    @Autowired
    SimpleAsyncTaskExecutor executor;
    @Autowired
    @Value("${excel.file.path}")
    private String filePath;
    private final JobRepository jobRepository;

    private final PlatformTransactionManager transactionManager;

    @Bean
    @StepScope
    public PoiItemReader<FeedRecord> feedRecordPoiItemReader() {
        PoiItemReader<FeedRecord> reader = new PoiItemReader<FeedRecord>();
        reader.setResource(new ClassPathResource(filePath));
        reader.setLinesToSkip(1);
        reader.setRowMapper(new FeedExcelMapper());
///reader.
        return reader;
    }

    //Multi -Thread Step -
    public Step multiThreadedStep() {
        StepBuilder builder = new StepBuilder("multiThreadedStep", jobRepository);
        return builder.chunk(2)
                .reader((ItemReader) feedRecordPoiItemReader())
                .writer(itemWriter)
                .taskExecutor(executor)
                .faultTolerant()
                .build();
    }

    @Bean
//main part in Spring Batch for multi-threading
    public Partitioner filePartitioner() {
        return new MultiResourcePartitioner();
    }
//use to process each partition
    @Bean
    public Step stepPartition() {
        StepBuilder builder = new StepBuilder("stepPartition", jobRepository);
        Step step = builder.chunk(2)
                .reader((ItemReader) feedRecordPoiItemReader())
                .writer(itemWriter)
                .faultTolerant()
                .build();

        return step;
    }
//to run partitioned steps in parallel threads
    @Bean
    public TaskExecutorPartitionHandler partitionHandler(Step stepPartition) {
        TaskExecutorPartitionHandler partitionHandler = new TaskExecutorPartitionHandler();
        partitionHandler.setStep(stepPartition);
        partitionHandler.setTaskExecutor(executor);
        partitionHandler.setGridSize(2);
        return partitionHandler;
    }
    //splitting work using partitioner and handler
    @Bean
    public Step masterPartitionStep(){
        StepBuilder builder = new StepBuilder("masterPartitionStep", jobRepository);
        Step step = builder
                .partitioner("stepPartition",filePartitioner())
                .partitionHandler(partitionHandler(stepPartition()))

                .build()
                ;

        return step;
    }
    //To Run Parallel Task
}
