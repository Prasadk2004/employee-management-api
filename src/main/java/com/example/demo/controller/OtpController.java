package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OtpService;

@RestController
@RequestMapping("/otp")
public class OtpController {
	
	@Autowired
	private OtpService otpService;
	
	@PostMapping("/verify")
	public String verifyOtp(@RequestParam String email, @RequestParam String otp) {
		return otpService.verifyOtp(email, otp);
	}
}