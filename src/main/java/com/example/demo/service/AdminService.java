package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Admin;

public interface AdminService {

	Admin addAdmin(Admin admin);

	List<Admin> getAllAdmins();

	Admin getAdminById(Long adminId);

	Admin updateAdmin(Long adminId, Admin admin);

	void deleteAdminById(Long AdminId);
}
