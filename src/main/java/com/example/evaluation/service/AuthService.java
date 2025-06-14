package com.example.evaluation.service;

import com.example.evaluation.dtos.LoginRequestDTO;
import com.example.evaluation.dtos.RegisterRequestDTO;

import java.util.Map;

public interface AuthService {
    void register(RegisterRequestDTO request);

    Map<String, String> login(LoginRequestDTO request);
}