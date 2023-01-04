package org.ntg.spring.database.pool;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Component("pool1")
@RequiredArgsConstructor
@Builder
@Slf4j
public class ConnectionPool {
    @Value("${db.username}")
    private final String userName;
    @Getter
    @Value("${db.poolSize}")
    private final int size;
    @Value("${db.poolSize}")
    private static int size2;

    @PostConstruct
    public void init(){
        log.info("init method");
    }

    @PreDestroy
    private void destroy() {
        log.info("CLeaning connection pool");
    }
}
