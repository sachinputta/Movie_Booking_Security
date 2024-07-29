package com.MovieBookingSecurity.main.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
	
	@Id
	private long adminid;
	private String fullname;
	private String password;
	private String email;
	private long mobileno;
	private String address;
	
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
//			mappedBy = "admin")
//	@JsonManagedReference
//	private List<Coupons> coupons;
	
}
