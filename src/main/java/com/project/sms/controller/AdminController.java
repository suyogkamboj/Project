package com.project.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.sms.model.Admin;
import com.project.sms.model.Authenticate;
import com.project.sms.service.AdminService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
//@RequestMapping("/api")
public class AdminController {

	@Autowired
	private AdminService adminService;

	// login
	@GetMapping("/Admin/{email}/{password}")
	public boolean validateAdmin(@PathVariable String email, @PathVariable String password) {
		return adminService.validateAdmin(email, password);
	}

}
