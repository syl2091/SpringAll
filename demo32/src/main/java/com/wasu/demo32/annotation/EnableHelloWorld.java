package com.wasu.demo32.annotation;


import com.wasu.demo32.configuration.HelloWorldConfiguration;
import com.wasu.demo32.selector.HelloWorldImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloWorldImportSelector.class)      //@Import(HelloWorldConfiguration.class)
public @interface EnableHelloWorld {

}
