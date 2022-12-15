package com.spring.C14S1SpringJWT.service;

import com.spring.C14S1SpringJWT.domain.User;

import java.util.List;

public interface IUserService {
    public User saveUser(User u);

    public User loginCheck(String emailId,String password);


}
