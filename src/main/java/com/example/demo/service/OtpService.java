package com.example.demo.service;

public interface OtpService {
	String sendOtp(String email);
	String verifyOtp(String email, String otp);
}
