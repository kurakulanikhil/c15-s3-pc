package com.spring.C14S1SpringJWT.service;

import com.spring.C14S1SpringJWT.domain.User;

import java.util.Map;

public interface ISecurityTokenGenerator {

    public Map<String,String> tokenGenerator(User user);
}
