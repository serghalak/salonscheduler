package com.salon.controller;


import com.salon.ui.model.request.UserRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    @GetMapping
    public String getUsers(){
        return "get user was called";
    }

    @PostMapping
    public String createUser(@RequestBody UserRequest userRequest){
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
        return "post create user was called";
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
