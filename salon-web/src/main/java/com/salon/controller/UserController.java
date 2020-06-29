package com.salon.controller;


import com.salon.ui.model.request.UserRequest;
import com.salon.ui.model.response.AuthorityResponse;
import com.salon.ui.model.response.UserResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/users")
public class UserController {

    @GetMapping
    public String getUsers(){
        return "get user was called";
    }

    @PostMapping(
           /* consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}*/)
    public UserResponse createUser(@RequestBody UserRequest userRequest){
        /*example post request for create user
        {
            "email":"serjhalak@rambler.ru",
            "firstName":"Serg",
            "lastName":"Halak",
            "phoneNumber":"0685419189",
            "userName":"SergHalalak01",
            "password":"123",
            "authorities":[
                {
                    "id":"1",
                    "roleName":"ADMIN"
                },
                {
                    "id":"2",
                    "roleName":"MASTER"
                },
                {
                    "id":"3",
                    "roleName":"CLIENT"
                }
            ]

        }
        */
        //System.out.println(userRequest.);
        //return "post create user was called";

        //test response
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId("123445");
        userResponse.setUserName("sh");
        userResponse.setActive(false);
        Set<AuthorityResponse>authorityResponseSet=new HashSet<>();
        AuthorityResponse ar=new AuthorityResponse();
        ar.setId(1L);
        ar.setRoleName("ADMIN");
        authorityResponseSet.add(ar);
        ar=new AuthorityResponse();
        ar.setId(2L);
        ar.setRoleName("MASTER");
        authorityResponseSet.add(ar);
        ar=new AuthorityResponse();
        ar.setId(3L);
        ar.setRoleName("CLIENT");
        authorityResponseSet.add(ar);
        userResponse.setAuthorities(authorityResponseSet);
        //end test

        return userResponse;

    }

    @PutMapping
    public String updateUser(){
        return "put update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user eas  called";
    }
}
