package org.ntg.spring.database.pool;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Component("pool1")
@RequiredArgsConstructor
@Builder
public class ConnectionPool {
    @Value("${db.username}")
    private final String userName;
    @Getter
    @Value("${db.poolSize}")
    private final int size;

    @PostConstruct
    public void init(){
        System.out.println("init method");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("CLeaning connection pool");
    }
}
