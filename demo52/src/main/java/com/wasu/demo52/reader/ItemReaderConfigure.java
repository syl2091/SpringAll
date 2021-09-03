package com.wasu.demo52.reader;

import com.wasu.demo52.entity.TestData;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:ItemReaderConfigure
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/30 9:24
 */
@Configuration
public class ItemReaderConfigure {

    @Bean
    public ListItemReader<TestData> simpleReader(){
        List<TestData> data = new ArrayList<>();
        TestData testData1 = new TestData();
        testData1.setId(20);
        testData1.setField1("11");
        testData1.setField2("12");
        testData1.setField3("13");
        data.add(testData1);
        TestData testData2 = new TestData();
        testData2.setId(30);
        testData2.setField1("21");
        testData2.setField2("22");
        testData2.setField3("23");
        data.add(testData2);

        TestData testData3 = new TestData();
        testData3.setId(31);
        testData3.setField1("31");
        testData3.setField2("32");
        testData3.setField3("33");

        return new ListItemReader<>(data);
    }
 }
