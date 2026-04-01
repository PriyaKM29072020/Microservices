package com.batch.batch.task;

import com.batch.batch.domain.FeedRecord;
import org.jspecify.annotations.Nullable;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.StepContribution;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.batch.infrastructure.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParallelTask implements Tasklet {
    @Value("${delimiter}")
    private String delimiter;
    @Value("${header}")
    private String header;
    @Value("${fileExtension}")
    private String fileExtension;
    @Value("${dbTableName}")
    private String dbTableName;
   @Autowired
    ItemWriter<FeedRecord> itemWriter;

    @Override
    public @Nullable RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {


        return RepeatStatus.FINISHED;
    }
}
