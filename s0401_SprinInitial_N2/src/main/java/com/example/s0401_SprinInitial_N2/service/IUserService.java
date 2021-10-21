package com.example.s0401_SprinInitial_N2.service;

import com.example.s0401_SprinInitial_N2.dto.UserResponseDto;

public interface IUserService {

    UserResponseDto getUser(String uuid);
}
