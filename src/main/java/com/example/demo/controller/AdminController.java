package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;

@RestController
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}

	@GetMapping("/allAdmin")
	public List<Admin> getAllAdmins() {
		return adminService.getAllAdmins();
	}

	@GetMapping("/{id}")
	public Admin getAdminById(@PathVariable Long id) {
		return adminService.getAdminById(id);
	}

	@PutMapping("/updateAdmin/{id}")
	public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
		return adminService.updateAdmin(id, admin);
	}

	@DeleteMapping("/deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable("id") Long id) {
		adminService.deleteAdminById(id);
		return "Admin deleted successfully with ID: " + id;
	}
}
