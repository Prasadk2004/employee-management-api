package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceIMPL implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee getEmployeeById(Long employeeId) {
		return employeeRepository.findById(employeeId).orElseThrow(()-> new RuntimeException("Employee not found with ID: " + employeeId));
	}
	
	@Override
	public Employee updateEmployee(Long employeeId, Employee newEmployeeInfo) {
		Employee oldEmployeeInfo = employeeRepository.findById(employeeId).orElseThrow(()-> new RuntimeException("Employee not found with ID: " + employeeId));
		
		oldEmployeeInfo.setEmployeeName(newEmployeeInfo.getEmployeeName());
		oldEmployeeInfo.setEmployeeEmail(newEmployeeInfo.getEmployeeEmail());
		oldEmployeeInfo.setEmployeeMobileNo(newEmployeeInfo.getEmployeeMobileNo());
		oldEmployeeInfo.setEmployeeDepartment(newEmployeeInfo.getEmployeeDepartment());
		oldEmployeeInfo.setEmployeeRole(newEmployeeInfo.getEmployeeRole());
		oldEmployeeInfo.setEmployeeBirthDate(newEmployeeInfo.getEmployeeBirthDate());
		oldEmployeeInfo.setEmployeePayrollCompany(newEmployeeInfo.getEmployeePayrollCompany());
		oldEmployeeInfo.setEmployeeOngoingProjects(newEmployeeInfo.getEmployeeOngoingProjects());
		oldEmployeeInfo.setEmployeeProjectDeploymentPlatform(newEmployeeInfo.getEmployeeProjectDeploymentPlatform());
		oldEmployeeInfo.setEmployeeProjectsUatUrl(newEmployeeInfo.getEmployeeProjectsUatUrl());
		oldEmployeeInfo.setEmployeeProjectsProductionUrl(newEmployeeInfo.getEmployeeProjectsProductionUrl());
		
		if (newEmployeeInfo.getProfilePictureUrl() != null) {
	        oldEmployeeInfo.setProfilePictureUrl(
	            newEmployeeInfo.getProfilePictureUrl());
	    }
		
		return employeeRepository.save(oldEmployeeInfo);
	}
	
	@Override
	public void deleteEmployeeById(Long employeeId) {
		employeeRepository.deleteById(employeeId);
	}
}
