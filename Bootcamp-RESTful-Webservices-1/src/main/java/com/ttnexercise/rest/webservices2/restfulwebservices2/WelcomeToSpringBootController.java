package com.ttnexercise.rest.webservices2.restfulwebservices2;

//Create a simple REST ful service in Spring Boot which returns the Response "Welcome to spring boot".

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeToSpringBootController {

    @GetMapping(path = "/welcomeMessage")
    public String welcomeMessage(){
        return "Welcome to spring boot";
    }
}
