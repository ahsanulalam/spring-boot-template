package com.blog.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ahsan on 3/28/2018.
 */
public interface IRepository <PK extends Serializable,T> {
    void insert(T entity);

    void insert(List<T> entity);

    void update(T entity);

    void update(List<T> entities);

    void delete(T entity);

    void delete(PK Id);

    T get(PK id);

    List<T> getAll();

    JPAQueryFactory QueryDSL();
}
