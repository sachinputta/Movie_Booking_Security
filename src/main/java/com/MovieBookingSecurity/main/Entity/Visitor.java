package com.MovieBookingSecurity.main.Entity;

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
	private long visitorid;
	private String fullname;
	private long mobileno;
	private String address;

}
