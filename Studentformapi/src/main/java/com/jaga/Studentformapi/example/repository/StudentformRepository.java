package com.jaga.Studentformapi.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaga.Studentformapi.example.model.Studentform;

public interface StudentformRepository extends JpaRepository< Studentform, Integer> {


	Studentform findByusername(String first_name);


}
 