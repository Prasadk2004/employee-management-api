package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.model.Otp;
import com.example.demo.repository.OtpRepository;

@Service
public class OtpServiceIMPL implements OtpService {

	@Autowired
	private OtpRepository otpRepository;
	
	@Autowired
	private JavaMailSender mailSender;
	
	private String generateOtp() {
		return String.valueOf(100000 + new Random().nextInt(900000));
	}
	
	@Override
	public String sendOtp(String email) {
		
		String otpCode = generateOtp();
		
		Otp otp = new Otp();
		otp.setEmail(email);
		otp.setOtp(otpCode);
		otp.setExpiryTime(LocalDateTime.now().plusMinutes(2));
		otp.setVerified(false);
		
		otpRepository.save(otp);
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("OTP Verification - Employee Management System.");
		message.setText("Your OTP is: " + otpCode + "\nValid for 2 minutes.");
		
		mailSender.send(message);
		
		System.out.println("OTP for " + email + " = " + otp);

		return "OTP generated and send successfully.";
	}

	@Override
	public String verifyOtp(String email, String otp) {
		
		Otp latestOtp = otpRepository.findTopByEmailOrderByIdDesc(email).orElse(null);
		
		if(latestOtp == null) {
			return "OTP not found.";
		}
		
		if(latestOtp.isVerified()) {
			return "OTP is already verified.";
		}
		
		if(latestOtp.getExpiryTime().isBefore(LocalDateTime.now())) {
			return "OTP is expired.";
		}
		
		if(!latestOtp.getOtp().equals(otp)) {
			return "OTP is invalid.";
		}
		
		latestOtp.setVerified(true);
		otpRepository.save(latestOtp);
		
		return "OTP Verified Successfully.";
	}
}
