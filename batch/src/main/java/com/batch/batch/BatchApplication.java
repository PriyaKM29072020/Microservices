package com.batch.batch;

import com.batch.batch.domain.FeedRecord;
import org.springframework.batch.extensions.excel.RowMapper;
import org.springframework.batch.extensions.excel.mapping.PassThroughRowMapper;
import org.springframework.batch.extensions.excel.poi.PoiItemReader;
import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.batch.infrastructure.item.file.transform.PassThroughFieldExtractor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class BatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}


    @Value("${excel.file.path}")
    private String filePath;

    @Bean
    public ItemReader<FeedRecord> employeeReader() {
        PoiItemReader<FeedRecord> reader = new PoiItemReader<FeedRecord>();
        reader.setResource(new ClassPathResource(filePath));
        reader.setLinesToSkip(1);

///reader.
        return (ItemReader<FeedRecord>) reader;
    }

}
