package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(Long employeeId);
	
	Employee updateEmployee(Long employeeId, Employee employee);
	
	void deleteEmployeeById(Long employeeId);
}
