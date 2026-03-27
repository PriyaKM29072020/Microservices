package com.batch.batch.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.batch.core.configuration.annotation.StepScope;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@StepScope
public class FeedLineMapper {
    private String filePath;
    private String fileName;
    private String fileExtension;
    private String delimiter;
    private String allHeadersFromFile;
    private String dbColumns;

}
