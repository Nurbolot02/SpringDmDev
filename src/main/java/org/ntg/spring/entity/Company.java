package org.ntg.spring.entity;

public class Company implements BaseEntity<Integer> {
    private Integer id;
    private String name;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
