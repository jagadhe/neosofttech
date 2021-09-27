package com.jaga.Studentformapi.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth/")
public class ApplicationController {


		


		
		@GetMapping("/getAll")
		public String getAll() {
			return "getting all Student_details";
		}

	}

