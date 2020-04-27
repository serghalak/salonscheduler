package com.salon.controller;



import com.salon.ui.model.request.ClientRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/clients")
public class ClientController {


    @GetMapping
    public void getAllClientAppointments(){
        System.out.println("api/clients get method ....");

    }

//    @PostMapping
//    public ClientResponse createUser(@RequestParam ClientRequest clientRequest){
//
//    }



}
