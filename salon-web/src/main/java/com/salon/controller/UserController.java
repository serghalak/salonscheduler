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
