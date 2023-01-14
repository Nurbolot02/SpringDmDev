package org.ntg.spring.database.entity;

public interface BaseEntity<T> {
    T getId();
    void setId(T id);
}
