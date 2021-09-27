package com.jaga.Studentformapi.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaga.Studentformapi.example.model.Studentform;
import com.jaga.Studentformapi.example.repository.StudentformRepository;

@RestController
@RequestMapping("/secure/auth/")
public class AdminController {
	
	@Autowired
	private StudentformRepository studentformRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	
	@PostMapping("/student_user/add")
	public String addUserByStudent_User(@RequestBody Studentform studentform) {
		String pwd=studentform.getPassword();
		
		String encryptPwd=passwordEncoder.encode(pwd);
		studentform.setPassword(encryptPwd);
		
		studentformRepository.save(studentform);
		
		return " Student_user added sucessfully";
		
	}
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/student_user/all")
	public String securedHello() {
		return "Secured hai";
	}
	

}
