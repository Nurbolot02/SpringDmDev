package org.ntg.spring;

import org.ntg.spring.config.DatabaseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringApplicationRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringApplicationRunner.class, args);
        Object pool1 = context.getBean("pool1");
        Object databaseProperties = context.getBean(DatabaseProperties.class);
        System.out.println(context.getBeanDefinitionCount());

        System.out.println(databaseProperties);
    }
}