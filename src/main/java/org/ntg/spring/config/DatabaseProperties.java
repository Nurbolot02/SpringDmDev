package org.ntg.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;


@ConfigurationProperties(prefix = "db")
public record DatabaseProperties(
        String name,
        String username,
        String password,
        Map<String, Object> properties,
        PoolProperties pool,
        List<PoolProperties> pools
) {


    public static record PoolProperties(Integer size, Integer timeout) {
    }
}
