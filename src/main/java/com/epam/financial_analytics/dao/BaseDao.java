package com.epam.financial_analytics.dao;

import java.util.List;

public interface BaseDao <E> {
    List<E> getAll();

    E getById(long id);

    void create(E entity);

    void update(E entity);

    void delete(E entity);

    void updateOrCreate (E entity, String sql);

}
