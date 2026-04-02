package com.batch.batch.writer;

import com.batch.batch.domain.FeedRecord;
import org.springframework.batch.infrastructure.item.Chunk;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.beans.factory.annotation.Value;

public class FeedItemWriter implements ItemWriter<FeedRecord> {
    @Value("${delimiter}")
    private final String delimiter;
    @Value("${header}")
    private final String header;
    @Value("${fileExtension}")
    private final String fileExtension;
    @Value("${delimiter}")
    private final String delimiter;
    @Value("${header}")
    private final String header;
    @Value("${fileExtension}")
    private final String fileExtension;


    @Override
    public void write(Chunk<? extends FeedRecord> chunk) throws Exception {

    }
}
