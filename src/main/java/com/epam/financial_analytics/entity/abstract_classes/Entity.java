package com.epam.financial_analytics.entity.abstract_classes;

public abstract class Entity {
    private long id;
    private String name;

    public Entity(){}

    public Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Entity(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id:" + id +
                ", name:" + name;
    }
}
