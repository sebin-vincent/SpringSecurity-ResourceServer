package com.example.springResource.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @PreAuthorize("hasRole('admincon')")
    @GetMapping("/admin")
    public String adminController(){

        return "Admin controller";
    }


    @PreAuthorize("hasRole('trainercon')")
    @GetMapping("/trainer")
    public String trainerController(){
        return "Admin controller";
    }

    @PreAuthorize("hasRole('traineecon')")
    @GetMapping("/trainee")
    public String traineeController(){
        return "Admin controller";
    }


}

