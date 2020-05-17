package com.epam.financial_analytics.dao;

import java.util.List;

public interface BaseDao <E> {
    List<E> getAll();

    E getByName(String name);

    void create(E entity);

    void update(E entity);

    void delete(E entity);

    void updateOrCreate (E entity, String sql);

}
