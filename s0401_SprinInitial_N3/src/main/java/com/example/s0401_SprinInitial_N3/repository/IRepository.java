package com.example.s0401_SprinInitial_N3.repository;

import com.example.s0401_SprinInitial_N3.dto.ResponseDto;

public interface IRepository {

    public ResponseDto getUser(String uuid);
}
