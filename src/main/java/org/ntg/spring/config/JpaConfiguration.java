package org.ntg.spring.config;

import org.ntg.spring.config.condition.JpaCondition;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Conditional(JpaCondition.class)
@Configuration
public class JpaConfiguration {
//    @Bean
//    @ConfigurationProperties(prefix = "db")
//    public DatabaseProperties databaseProperties(){
//        return new DatabaseProperties();
//    }
    @PostConstruct
    private void init(){
        System.out.println("JpaConfiguration is enabled");
    }
}
