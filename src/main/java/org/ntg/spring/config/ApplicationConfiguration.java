package org.ntg.spring.config;

import org.ntg.spring.database.pool.ConnectionPool;
import org.ntg.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(WebConfiguration.class)
@Configuration
//@ComponentScan(basePackages = "org.ntg",
//        useDefaultFilters = false,
//        includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Component.class),
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
//                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org\\..+Repository")
//        }
//)
@ComponentScan()
public class ApplicationConfiguration {
        @Bean(name = "driver")
        public String getDriver(@Value("${db.name}") String dbName){
                return dbName;
        }

        @Bean
        public ConnectionPool pool2(@Value("${db.username}") String username){
                return ConnectionPool.builder()
                        .userName(username)
                        .size(5)
                        .build();
        }
}
