package com.wasu.demo53.processor;

import com.wasu.demo53.entity.TestData;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName:TestDataTransformItemPorcessor
 * @Description: 数据转换
 * @Author: Syl
 * @Date: 2021/9/3 10:32
 */
@Component
public class TestDataTransformItemPorcessor implements ItemProcessor<TestData,TestData> {

    @Override
    public TestData process(TestData testData) throws Exception {
        // field1值拼接 hello
        testData.setField1(testData.getField1() + " hello");
        return testData;
    }
}
