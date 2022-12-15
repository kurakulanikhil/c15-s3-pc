package com.spring.C14S1SpringJWT.controller;


import com.spring.C14S1SpringJWT.domain.User;
import com.spring.C14S1SpringJWT.service.ISecurityTokenGenerator;
import com.spring.C14S1SpringJWT.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")

public class UserController {
    private IUserService userService;
    private ISecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(IUserService userService, ISecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }






    //http://localhost:8082/api/v1/users  -- POST
    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody  User u){
        return new ResponseEntity<>(userService.saveUser(u),HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody User user){
        User result=userService.loginCheck(user.getEmail(),user.getPassword());
        if(result!=null){
            //valid user
            //generate security token
            Map<String,String> map=securityTokenGenerator.tokenGenerator(user);
            return new ResponseEntity<>(map,HttpStatus.OK);

        }else{
            //invalid or not exist
            return new ResponseEntity("invalid user", HttpStatus.NOT_FOUND);


        }
    }




}
