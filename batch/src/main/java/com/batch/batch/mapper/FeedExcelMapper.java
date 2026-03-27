package com.batch.batch.mapper;

import com.batch.batch.domain.FeedRecord;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.extensions.excel.RowMapper;
import org.springframework.batch.extensions.excel.support.rowset.RowSet;
import org.springframework.beans.factory.annotation.Value;

@StepScope
@Setter
@Getter
@NoArgsConstructor
public class FeedExcelMapper implements RowMapper<FeedRecord>  {
    @Value("${delimiter}")
private String delimiter;
private String header;
private String fileExtension;

    @Override
    public FeedRecord mapRow(RowSet rowSet) throws Exception {
FeedRecord feedRecord=new FeedRecord();
String[] feedHeaders=header.split(delimiter);
int feedHeaderSize=feedHeaders.length;
//feedRecord.setColumns(rowSet.getCurrentRow());
        Object[] rows=new Object[feedHeaderSize];
        for (int i=0;i<feedHeaderSize;i++){
            rows[i]=rowSet.getProperties().getProperty(feedHeaders[i]);
        }
        feedRecord.setColumns(rows);
        return feedRecord;
    }
}
