package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminServiceIMPL implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public Admin getAdminById(Long adminId) {
		return adminRepository.findById(adminId)
				.orElseThrow(() -> new RuntimeException("Admin not found with ID: " + adminId));
	}

	@Override
	public Admin updateAdmin(Long adminId, Admin updatedAdmin) {

		Admin existingAdmin = adminRepository.findById(adminId).orElseThrow(() -> new RuntimeException("Admin not found with ID: " + adminId));

		existingAdmin.setAdminName(updatedAdmin.getAdminName());
		existingAdmin.setAdminEmail(updatedAdmin.getAdminEmail());
		existingAdmin.setAdminMobileNo(updatedAdmin.getAdminMobileNo());
		existingAdmin.setAdminDepartment(updatedAdmin.getAdminDepartment());
		existingAdmin.setAdminRole(updatedAdmin.getAdminRole());
		existingAdmin.setAdminBirthDate(updatedAdmin.getAdminBirthDate());
		existingAdmin.setAdminPayrollCompany(updatedAdmin.getAdminPayrollCompany());
		existingAdmin.setAdminPassword(updatedAdmin.getAdminPassword());

		return adminRepository.save(existingAdmin);
	}

	@Override
	public void deleteAdminById(Long AdminId) {
		adminRepository.deleteById(AdminId);
	}
}
