package com.jaga.Studentformapi.example.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jaga.Studentformapi.example.model.Studentform;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CustomUserDetails  implements UserDetails{
	private static final long serialVersionUID =1234556677789L;
	
	private Studentform studentform;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return studentform.getProjects().stream().map(project-> new SimpleGrantedAuthority("Project_"+project)).collect(Collectors.toList());
		
	}

	@Override
	public String getPassword() {
		
		return studentform.getPassword();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Studentform getStudentform() {
		return studentform;
	}

	@Override
	public String getUsername() {
	
		return studentform.getFirst_name();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

	public void setStudentform(Studentform studentform) {
		// TODO Auto-generated method stub
		
	}

}
