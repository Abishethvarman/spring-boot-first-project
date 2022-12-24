package com.abishethvarman.Springbootfirstproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class HelloController {
    @GetMapping(value = "/")
    public String helloWorld(){
        return "Welcome to hello controller" ;
    }

}
