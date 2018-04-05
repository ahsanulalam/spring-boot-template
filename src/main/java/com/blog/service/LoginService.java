package com.blog.service;

import com.blog.model.UserLogin;

/**
 * Created by Ahsan on 3/28/2018.
 */
public interface LoginService {
    UserLogin GetUser(String emailId);

}
