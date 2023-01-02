package org.ntg.spring.database.pool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Component("pool1")
public class ConnectionPool {
    private final String userName;
    private int size;

    public ConnectionPool(
            @Value("${db.username}") String userName,
            @Value("${db.poolSize}") int size) {
        this.userName = userName;
        this.size = size;
    }

    @PostConstruct
    public void init(){
        System.out.println("init method");
    }

    public void setSize(int size) {
        this.size = size;
    }

    @PreDestroy
    private void destroy() {
        System.out.println("CLeaning connection pool");
    }
}
