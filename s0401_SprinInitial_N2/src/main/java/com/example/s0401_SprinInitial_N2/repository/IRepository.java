package com.example.s0401_SprinInitial_N2.repository;

import com.example.s0401_SprinInitial_N2.dto.ResponseDto;

public interface IRepository {

    public ResponseDto getUser(String uuid);
}
