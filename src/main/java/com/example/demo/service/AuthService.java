package com.example.demo.service;

import com.example.demo.dto.LoginRequest;

public interface AuthService {
	String loginAndSendOtp(LoginRequest request);
}
