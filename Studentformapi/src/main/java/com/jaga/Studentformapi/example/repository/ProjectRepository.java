package com.jaga.Studentformapi.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaga.Studentformapi.example.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
