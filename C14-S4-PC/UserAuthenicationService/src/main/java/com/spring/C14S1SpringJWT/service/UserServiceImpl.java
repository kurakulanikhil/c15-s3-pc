package com.spring.C14S1SpringJWT.service;

import com.spring.C14S1SpringJWT.domain.User;
import com.spring.C14S1SpringJWT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRespository;

    @Override
    public User saveUser(User u) {
        return userRespository.save(u);
    }


    @Override
    public User loginCheck(String emailId, String password) {
        if(userRespository.findById(emailId).isPresent()){
            // get userobjet by using emailId
            User user=userRespository.findById(emailId).get();
            //check password
            if(user.getPassword().equals(password)){
                user.setPassword("");
                return user;
            }else{
                //invalid user
                return null;
            }

        }else{
            //user not exits
            return null;
        }
    }
}
