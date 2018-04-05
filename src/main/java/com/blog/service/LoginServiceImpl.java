package com.blog.service;

import com.blog.dao.GenericRepository;
import com.blog.dao.IRepository;
import com.blog.model.QUserLogin;
import com.blog.model.UserLogin;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.RollbackException;

/**
 * Created by Ahsan on 3/28/2018.
 */
@Service("LoginService")
@Transactional(rollbackFor = Exception.class)
public class LoginServiceImpl implements LoginService {

    IRepository<Integer,UserLogin> userLoginIRepository;


    public LoginServiceImpl(GenericRepository<Integer,UserLogin> userLogin){
        userLoginIRepository = userLogin;
        userLogin.setEntity(UserLogin.class);
    }
    @Override
    public UserLogin GetUser(String emailId) {
        return
               userLoginIRepository.QueryDSL()
                       .select(QUserLogin.userLogin)
                       .from(QUserLogin.userLogin)
                       .where(QUserLogin.userLogin.userName.eq(emailId))
                       .fetchOne();
    }
}
