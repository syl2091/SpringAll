package com.wasu.demo32.selector;

import com.wasu.demo32.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName:HelloWorldImportSelector
 * @Description: TODO
 * @Author: Syl
 * @Date: 2021/8/12 13:39
 */
public class HelloWorldImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{HelloWorldConfiguration.class.getName()};
    }
}
