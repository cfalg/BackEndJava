package com.example.s0401_SprinInitial_N3.service;

import com.example.s0401_SprinInitial_N3.dto.UserResponseDto;

public interface IUserService {

    UserResponseDto getUser(String uuid);
}
