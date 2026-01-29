package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequest;
import com.example.demo.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	//this is for otp
	@Autowired
	private AuthService authService;
	
	@PostMapping("/send-otp")
	public String LoginSendOtp(@RequestBody LoginRequest request) {
		return authService.loginAndSendOtp(request);
	}
}
