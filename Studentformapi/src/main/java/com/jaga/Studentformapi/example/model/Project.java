package com.jaga.Studentformapi.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Project {
	@Id
	@GeneratedValue
  private int projid;
  private String projname;
  private int duration;
}
