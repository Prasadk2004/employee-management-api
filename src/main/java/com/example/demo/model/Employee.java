package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;

	private String employeeName;

	@Column(unique = true, length = 10)
	private String employeeMobileNo;

	@Column(unique = true)
	private String employeeEmail;
	
	@Column(nullable = true)
	private String profilePictureUrl;

	private String employeeDepartment;
	private String employeeRole;

	private LocalDate employeeBirthDate;
	
	private String employeePassword;

	private String employeePayrollCompany;

	private String employeeOngoingProjects;

	private String employeeProjectDeploymentPlatform;

	private String employeeProjectsUatUrl;

	private String employeeProjectsProductionUrl;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public LocalDate getEmployeeBirthDate() {
		return employeeBirthDate;
	}

	public void setEmployeeBirthDate(LocalDate employeeBirthDate) {
		this.employeeBirthDate = employeeBirthDate;
	}

	public String getEmployeePayrollCompany() {
		return employeePayrollCompany;
	}

	public void setEmployeePayrollCompany(String employeePayrollCompany) {
		this.employeePayrollCompany = employeePayrollCompany;
	}

	public String getEmployeeOngoingProjects() {
		return employeeOngoingProjects;
	}

	public void setEmployeeOngoingProjects(String employeeOngoingProjects) {
		this.employeeOngoingProjects = employeeOngoingProjects;
	}

	public String getEmployeeProjectDeploymentPlatform() {
		return employeeProjectDeploymentPlatform;
	}

	public void setEmployeeProjectDeploymentPlatform(String employeeProjectDeploymentPlatform) {
		this.employeeProjectDeploymentPlatform = employeeProjectDeploymentPlatform;
	}

	public String getEmployeeProjectsUatUrl() {
		return employeeProjectsUatUrl;
	}

	public void setEmployeeProjectsUatUrl(String employeeProjectsUatUrl) {
		this.employeeProjectsUatUrl = employeeProjectsUatUrl;
	}

	public String getEmployeeProjectsProductionUrl() {
		return employeeProjectsProductionUrl;
	}

	public void setEmployeeProjectsProductionUrl(String employeeProjectsProductionUrl) {
		this.employeeProjectsProductionUrl = employeeProjectsProductionUrl;
	}

	public String getEmployeeMobileNo() {
		return employeeMobileNo;
	}

	public void setEmployeeMobileNo(String employeeMobileNo) {
		this.employeeMobileNo = employeeMobileNo;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}

}
