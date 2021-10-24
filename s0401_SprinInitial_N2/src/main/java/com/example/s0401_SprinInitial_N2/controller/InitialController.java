package com.example.s0401_SprinInitial_N2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.s0401_SprinInitial_N2.dto.UserResponseDto;
import com.example.s0401_SprinInitial_N2.service.IUserService;

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
        return "Hello World!" + " ---> Tasca S4.01 Spring Initial - Nivell 2 - Part 1";
    }

    @GetMapping("/{user}")
    public String helloGradle_N1F2_2( @PathVariable(name="user") String user) {
        return "Hello, "+ user + " ---> Tasca S4.01 Spring Initial - Nivell 2 - Part 2";
    }
    
    
   
}

