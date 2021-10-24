package com.example.s0401_SprinInitial_N2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.s0401_SprinInitial_N2.dto.UserResponseDto;

@Repository

public class UserRepository implements IRepository {

    @Autowired
    private UserResponseDto userResponseDto;

    public UserResponseDto getUser (String uuid){
        userResponseDto.setName("Jonatan");
        userResponseDto.setSurname("Vicente");
        userResponseDto.setGender("Male");
        return userResponseDto;
    }


}
