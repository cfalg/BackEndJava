package com.example.s0401_SprinInitial_N3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.s0401_SprinInitial_N3.service.IUserService;

@RestController
@RequestMapping("/")
public class InitialController {

    private final IUserService userService;

    @Autowired
    public InitialController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public String helloGradle() {
        return "Hello World!" + " ---> Tasca S4.01 Spring Initial - Nivell 3 - Part 1";
    }

    @GetMapping("/{user}")
    public String helloGradle_N1F2_2( @PathVariable(name="user") String user) {
        return "Hello, "+ user + " ---> Tasca S4.01 Spring Initial - Nivell 3 - Part 2";
    }
    
    
   
}

