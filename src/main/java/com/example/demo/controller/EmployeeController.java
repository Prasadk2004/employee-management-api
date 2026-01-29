package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
	    return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/allEmployee")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployees();
		
	}
	
	@GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }
	
	@PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }
	
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id")Long id) {
		employeeService.deleteEmployeeById(id);
		return "Employee deleted successfully with ID: " + id;
	}
}
