package com.wasu.demo38.config;

import com.wasu.demo38.condition.MyCondition;
import com.wasu.demo38.entity.Hello;
import com.wasu.demo38.entity.User;
import com.wasu.demo38.factory.FactoryBean;
import org.springframework.context.annotation.*;

/**
 * @ClassName:WebConfig
 * @Description: excludeFilters指定哪里不被扫描
 * @Author: Syl
 * @Date: 2021/8/13 15:49
 */
@Configuration
@Import(Hello.class)   // import快速导入组件
/*@ComponentScan(value = "com.wasu.demo38",excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
classes = {Controller.class, Repository.class}),
@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = User.class)})*/
public class WebConfig {

    /**
     * 通过 @Bean 注解向 ioc容器注入 user对象  singleton：单实例（默认） prototype：多实例  request：一个请求对应一个实例； session：同一个session对应一个实例。
     *
     * @return
     */
    @Bean("myUser")
    @Lazy
    @Conditional(MyCondition.class)
    public User user() {
        System.out.println("往IOC容器中注册user bean");
        return new User("syl", 23);
    }


    @Bean
    public FactoryBean cherryFactoryBean() {
        return new FactoryBean();
    }
}
