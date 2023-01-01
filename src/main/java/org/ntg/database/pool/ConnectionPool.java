package org.ntg.database.pool;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;

public class ConnectionPool {
    private final String userName;
    private int size;
    private final List<Object> args;
    private final Map<String, Object> properties;

    public ConnectionPool(String userName, int size, List<Object> args, Map<String, Object> properties) {
        this.userName = userName;
        this.size = size;
        this.args = args;
        this.properties = properties;
    }

    @PostConstruct
    public void init(){
        System.out.println("init method");
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @PreDestroy
    private void destroy() {
        System.out.println("CLeaning connection pool");
    }
}
