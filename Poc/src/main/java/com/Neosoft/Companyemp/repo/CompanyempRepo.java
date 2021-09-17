package com.Neosoft.Companyemp.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Neosoft.Companyemp.entity.Companyemp;

@Repository
public interface CompanyempRepo extends JpaRepository<Companyemp, Integer>{
	
 public abstract List<Companyemp> findByNameOrSurname(String name, String surname);
 public abstract List<Companyemp> findByNameOrPincode(String name, Integer pincode);
 public abstract List<Companyemp> findByDobOrJoiningdate(Date dob, Date joiningdate);

}
