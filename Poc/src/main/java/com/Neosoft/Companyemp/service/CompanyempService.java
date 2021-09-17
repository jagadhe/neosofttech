package com.Neosoft.Companyemp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Neosoft.Companyemp.entity.Companyemp;
import com.Neosoft.Companyemp.repo.CompanyempRepo;


@Service 
public class CompanyempService {
	@Autowired
	private CompanyempRepo emprepo;
	

	
	public Companyemp register(Companyemp e) {
		emprepo.save(e);
		return e;
	}
	public List<Companyemp> getUser(Companyemp e)
	{
		return (List<Companyemp>) emprepo.findByNameOrSurname(e.getName(),e.getSurname());
	}
	public List<Companyemp> getUserp(Companyemp e)
	{
		return (List<Companyemp>) emprepo.findByNameOrPincode(e.getName(),e.getPincode());
	}
	public void update(Companyemp e,Integer id) {
		emprepo.save(e);
	}
	public List<Companyemp> sortbydodandjoingdate(Date dob,Date joiningdate){
	 List<Companyemp> findByDobOrJoiningdate = emprepo.findByDobOrJoiningdate(dob, joiningdate);
	return findByDobOrJoiningdate;
	}
	public void delete(Integer id) {
		Optional<Companyemp> companyemp = emprepo.findById(id);
		if(companyemp.isPresent()) {
			emprepo.delete(companyemp.get());
		}else {
			throw new RuntimeException("companyemp with id is not present"+id);
		}
	}


}
