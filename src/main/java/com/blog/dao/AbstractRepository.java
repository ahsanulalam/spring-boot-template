package com.blog.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Ahsan on 3/28/2018.
 */
public class AbstractRepository<PK extends Serializable, T> {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    EntityManager entityManagerExtended;

    @PersistenceContext
    EntityManager entityManager;

    private Class<T> entity;
    private CriteriaBuilder builder;
    private List<Predicate> predicateList;
    private List<Order> orderList;


//    public EntityManager getEntityManager(){
//        return this.entityManager;
//    }

    public void setEntity(Class<T> entity) {
        this.entity = entity;
    }

    public T get(PK id){
        return (T)entityManagerExtended.find(entity,id);
    }

    public List<T> getAll()
    {
        return entityManagerExtended.createQuery("from "+entity.getName()).getResultList();
    }

    public void insert(T entity) {
        entityManager.persist(entity);
    }

    public void insert(List<T> entities) {
        for(T entity:entities) {
            entityManager.persist(entity);
        }
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void update(List<T> entities){
        for(T entity:entities) {
            entityManager.merge(entity);
        }
    }

    public void delete(T entity) { entityManager.remove(entity); }

    public void delete(PK id){
        delete(entityManager.find(entity,id));
    }

    public JPAQueryFactory QueryDSL(){
        return new JPAQueryFactory(entityManager);
    }

    public List<T> getByProcedure(String procedureName, String... input) {
        //List<T> query = new ArrayList<>();


        StoredProcedureQuery storeProccedure = entityManager.createStoredProcedureQuery(procedureName);
        for (int i=0;i<input.length;i++) {
            storeProccedure.registerStoredProcedureParameter("in_param"+i, String.class, ParameterMode.IN);
            storeProccedure.setParameter("in_param"+i, input);

        }

        // storeProccedure.registerStoredProcedureParameter("name", String.class, ParameterMode.OUT);
        //storeProccedure.registerStoredProcedureParameter("designation", String.class, ParameterMode.OUT);
        // storeProccedure.registerStoredProcedureParameter("salary", String.class, ParameterMode.OUT);

//        for (int i=0;i<input.length();i++) {
//            storeProccedure.setParameter("in_param"+i, input);
//            storeProccedure.registerStoredProcedureParameter("in_param"+i, String.class, ParameterMode.IN);
//        }

        storeProccedure.execute();
        return storeProccedure.getResultList();


        // queryEmp.setEmpName(storeProccedure.getOutputParameterValue("name").toString());
        //queryEmp.setEmpDesignation(storeProccedure.getOutputParameterValue("designation").toString());
        //queryEmp.setEmpSalary(storeProccedure.getOutputParameterValue("salary").toString());
        //query.add(queryEmp);

        //return query;
    }
}
