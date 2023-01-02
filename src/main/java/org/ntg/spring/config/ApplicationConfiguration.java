package org.ntg.spring.config;

import org.ntg.spring.database.repository.CrudRepository;
import org.ntg.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Import(WebConfiguration.class)
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "org.ntg",
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Component.class),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org\\..+Repository")
        }
)
public class ApplicationConfiguration {
        @Bean(name = "driver")
        public String getDriver(@Value("${db.name}") String dbName){
                return dbName;
        }
}
