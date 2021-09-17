package com.Neosoft.Companyemp.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Neosoft.Companyemp.entity.Companyemp;
import com.Neosoft.Companyemp.service.CompanyempService;



@RestController
@RequestMapping("Companyemp")
public class CompanyempController {
	@Autowired
	private CompanyempService service;
	
	@PostMapping("/registeruser")
	public ResponseEntity<Companyemp> registeruser(@RequestBody @Valid Companyemp e){
		Companyemp register = service.register(e);
		
		return new ResponseEntity<Companyemp>(register,HttpStatus.CREATED);
	}
	@GetMapping("/getuser")
	public ResponseEntity<List<Companyemp>> getuser(Companyemp e){
		List<Companyemp> user = service.getUser(e);
		ResponseEntity<List<Companyemp>> re= new ResponseEntity<List<Companyemp>>(user,HttpStatus.OK);
		return re;
	}
	@GetMapping("/getuserp")
	public ResponseEntity<List<Companyemp>> getuserp(Companyemp e){
		List<Companyemp> user = service.getUserp(e);
		ResponseEntity<List<Companyemp>> re= new ResponseEntity<List<Companyemp>>(user,HttpStatus.OK);
		return re;
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Companyemp> update(@RequestBody Companyemp e,@PathVariable("id") Integer id){
		service.update(e, id);
		ResponseEntity<Companyemp> re= new ResponseEntity<Companyemp>(e,HttpStatus.CREATED);
		return re;
	}
	@GetMapping("/sortbydobandjoiningdate/{dob}/{joiningdate}")
	public ResponseEntity<List<Companyemp>> SortByDobandJoiningDate(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date dob,
			  @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date joiningdate){
		List<Companyemp> sortbydodandjoingdate = service.sortbydodandjoingdate(dob, joiningdate);
	return ResponseEntity.ok(sortbydodandjoingdate);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity delete(@PathVariable Integer id) {
		service.delete(id);
		ResponseEntity re= new ResponseEntity<>(HttpStatus.ACCEPTED); 
		return re;
	}

}
