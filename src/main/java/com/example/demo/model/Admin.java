package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long AdminId;
	
	private String adminName;

	@Column(unique = true, length = 10)
	private String adminMobileNo;

	@Column(unique = true)
	private String adminEmail;
	
	private String adminPassword;

	private String adminDepartment;
	private String adminRole;

	private LocalDate adminBirthDate;

	private String adminPayrollCompany;

	public Long getAdminId() {
		return AdminId;
	}

	public void setAdminId(Long adminId) {
		AdminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminDepartment() {
		return adminDepartment;
	}

	public void setAdminDepartment(String adminDepartment) {
		this.adminDepartment = adminDepartment;
	}

	public String getAdminRole() {
		return adminRole;
	}

	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}

	public LocalDate getAdminBirthDate() {
		return adminBirthDate;
	}

	public void setAdminBirthDate(LocalDate adminBirthDate) {
		this.adminBirthDate = adminBirthDate;
	}

	public String getAdminPayrollCompany() {
		return adminPayrollCompany;
	}

	public void setAdminPayrollCompany(String adminPayrollCompany) {
		this.adminPayrollCompany = adminPayrollCompany;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminMobileNo() {
		return adminMobileNo;
	}

	public void setAdminMobileNo(String adminMobileNo) {
		this.adminMobileNo = adminMobileNo;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

}
