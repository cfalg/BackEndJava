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
@RequestMapping("/v1")
public class InitialController {

    private final IUserService userService;

    @Autowired
    public InitialController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping("/test")
    public String helloGradle() {
        return "Hello Gradle Carles!";
    }

    
    @GetMapping("/test_N2")
    public String helloGradle_N2() {
        return "Hello Gradle Carles Nivell 2!";
    }

    
    @GetMapping("/test_N2/{user}")
    public String helloGradle_N1F2_2( @PathVariable(name="user") String user) {
        return "Hello Gradle "+ user + " Nivell 2";
    }
    
    //@PutMapping(value ="", consumes = {"application/json"})
    @GetMapping("/user/{uuid}")
    public ResponseEntity<UserResponseDto> updatePrescription(
            @PathVariable(name="uuid") String user) throws Exception {


        UserResponseDto userResponseDto = userService.getUser("pp");

        System.out.println(userResponseDto.getName());
        System.out.println(userResponseDto.getSurname());
        System.out.println(userResponseDto.getGender());

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);

    }


}
