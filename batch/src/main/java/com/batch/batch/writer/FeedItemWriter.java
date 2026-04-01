package com.batch.batch.writer;

import com.batch.batch.domain.FeedRecord;
import org.springframework.batch.infrastructure.item.Chunk;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.beans.factory.annotation.Value;

public class FeedItemWriter implements ItemWriter<FeedRecord> {
    @Value("${delimiter}")
    private String delimiter;
    @Value("${header}")
    private String header;
    @Value("${fileExtension}")
    private String fileExtension;
    @Value("${delimiter}")
    private String delimiter;
    @Value("${header}")
    private String header;
    @Value("${fileExtension}")
    private String fileExtension;


    @Override
    public void write(Chunk<? extends FeedRecord> chunk) throws Exception {

    }
}
