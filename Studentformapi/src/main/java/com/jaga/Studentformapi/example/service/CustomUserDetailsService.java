package com.jaga.Studentformapi.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jaga.Studentformapi.example.model.Studentform;
import com.jaga.Studentformapi.example.repository.StudentformRepository;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private StudentformRepository repository;

	@Override
	public UserDetails loadUserByUsername(String first_name) throws UsernameNotFoundException {
		
		Studentform studentform=repository.findByusername(first_name);
		CustomUserDetails userDetails=null;
		if(studentform!=null) {
			userDetails=new CustomUserDetails();
			
			userDetails.setStudentform(studentform);
		}else {
			throw new UsernameNotFoundException("user not exist with  name: "+first_name);
		}
		return userDetails;
	

	}
	
	
	

}
