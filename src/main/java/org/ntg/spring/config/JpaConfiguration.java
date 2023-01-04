package org.ntg.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.ntg.spring.config.condition.JpaCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Conditional(JpaCondition.class)
@Configuration
@Slf4j
public class JpaConfiguration {
//    @Bean
//    @ConfigurationProperties(prefix = "db")
//    public DatabaseProperties databaseProperties(){
//        return new DatabaseProperties();
//    }
    @PostConstruct
    private void init(){
        log.info("JpaConfiguration is enabled");
    }
}
