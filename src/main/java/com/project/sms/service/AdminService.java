package com.project.sms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sms.dao.AdminDAO;
import com.project.sms.model.Admin;
import com.project.sms.model.Faculty;

@Service
@Transactional
public class AdminService {
	@Autowired
	private AdminDAO adminDao;

	public Admin signUpAdmin(Admin adminuser) {

		// save admin details
		return adminDao.save(adminuser);
	}

//Admin login
	public boolean validateAdmin(String email, String password) {
		Admin admin = adminDao.findAdminByEmail(email);
		if (admin == null) {
			return false;
		} else {
			if (admin.getPassword().equals(password)) {
				return true;
			} else
				return false;
		}
	}
}
