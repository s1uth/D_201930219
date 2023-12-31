package com.example.d_201930219.service;

import com.example.d_201930219.dto.SignInResultDto;
import com.example.d_201930219.dto.SignUpResultDto;

public interface SignService {

    SignUpResultDto signUp(String id, String password, String name, String email, String role);

    SignInResultDto signIn(String id, String password) throws RuntimeException;

}