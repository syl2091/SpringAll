package com.wasu.demo38.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName:MyCondition
 * @Description: 条件注册组件
 * @Author: Syl
 * @Date: 2021/8/13 17:08
 */
public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        /**
         * 条件:在Windows环境下，User这个组件将被成功注册，如果是别的操作系统，这个组件将不会被注册到IOC容器中。
         */
        String osName = conditionContext.getEnvironment().getProperty("os.name");
        return osName != null && osName.contains("Windows");
    }
}
