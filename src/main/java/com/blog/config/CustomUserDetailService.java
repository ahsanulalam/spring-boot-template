package com.blog.config;

import com.blog.model.UserLogin;
import com.blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ahsan on 3/28/2018.
 */
@Service("CustomUserDetailService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    LoginService loginService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || username == "") {
            throw new UsernameNotFoundException("");
        } else {
            UserLogin user = loginService.GetUser(username);
            return new User(user.getUserName(),user.getPassword(), getGrantedAuthorities(user.getUserTypeByUserTypeId().getType()));

            //return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
              //      true, true, true, true, getGrantedAuthorities(user.getUserTypeByUserTypeId().getType()));
        }
   }
    private List<GrantedAuthority> getGrantedAuthorities(String userRoleType){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add( new SimpleGrantedAuthority(userRoleType));
        return authorities;
    }
}
