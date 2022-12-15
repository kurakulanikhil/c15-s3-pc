package com.spring.C14S1SpringJWT.service;

import com.spring.C14S1SpringJWT.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements  ISecurityTokenGenerator{
    @Override
    public Map<String, String> tokenGenerator(User user) {
        String jwtToken=null;


        jwtToken= Jwts.builder()// jetbuilder instance
                .setSubject(user.getFirstName())// set sub as user firstname
                .setIssuedAt(new Date())// date
                .signWith(SignatureAlgorithm.HS256,"securityKey")// algo and key(at time of filter)
                .compact();

        Map<String,String> map=new HashMap<>();
        map.put("token",jwtToken);
        map.put("message","User successfully loggedin");
        return map;
    }
}
