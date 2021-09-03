package com.wasu.demo53.processor;

import com.wasu.demo53.entity.TestData;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName:TestDataFilterItemProcessor
 * @Description: 自定义ItemProcessor的实现类
 * @Author: Syl
 * @Date: 2021/9/3 10:23
 */
@Component
public class TestDataFilterItemProcessor implements ItemProcessor<TestData,TestData> {
    @Override
    public TestData process(TestData testData) throws Exception {
        return "".equals(testData.getField3()) ? null : testData;
    }
}
