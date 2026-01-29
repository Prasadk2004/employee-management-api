package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.model.Admin;
import com.example.demo.model.Employee;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.EmployeeRepository;

@Service
public class AuthServiceIMPL implements AuthService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private OtpService otpService;

	@Override
	public String loginAndSendOtp(LoginRequest request) {
		if (request.getUserType().equalsIgnoreCase("EMPLOYEE")) {
			Optional<Employee> emp = employeeRepository.findByEmployeeIdAndEmployeeEmail(request.getId(), request.getEmail());

			if (emp.isEmpty()) {
				return "Employee not found with this ID and Email.";
			}

			if (!emp.get().getEmployeePassword().equals(request.getPassword())) {
				return "Invalid Employee Password.";
			}
			
			return otpService.sendOtp(request.getEmail());

		} else if (request.getUserType().equalsIgnoreCase("ADMIN")) {
			Optional<Admin> admin = adminRepository.findByAdminIdAndAdminEmail(request.getId(), request.getEmail());

			if (admin.isEmpty()) {
				return "Employee not found with this ID and Email.";
			}

			if (!admin.get().getAdminPassword().equals(request.getPassword())) {
				return "Invalid Employee Password.";
			}

			return otpService.sendOtp(request.getEmail());

		}
		return "Invalid userType! Use ADMIN or EMPLOYEE.";
	}

}
