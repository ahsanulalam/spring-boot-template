package com.blog.dao;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

/**
 * Created by Ahsan on 3/28/2018.
 */

@Repository("IRepository")
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class GenericRepository<PK extends Serializable, T> extends AbstractRepository<PK , T> implements IRepository<PK , T>{



}
