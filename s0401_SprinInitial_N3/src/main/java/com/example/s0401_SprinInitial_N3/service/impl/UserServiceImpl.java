package com.example.s0401_SprinInitial_N3.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.s0401_SprinInitial_N3.dto.UserResponseDto;
import com.example.s0401_SprinInitial_N3.repository.UserRepository;
import com.example.s0401_SprinInitial_N3.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserResponseDto getUser(String uuid){
        return userRepository.getUser(uuid);
    }

}
