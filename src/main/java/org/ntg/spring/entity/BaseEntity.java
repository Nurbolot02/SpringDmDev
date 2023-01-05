package org.ntg.spring.entity;

public interface BaseEntity<T> {
    T getId();
    void setId(T id);
}
