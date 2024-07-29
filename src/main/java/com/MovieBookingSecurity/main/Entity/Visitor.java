package com.MovieBookingSecurity.main.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Visitor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long visitorid;
	private String location;

}
