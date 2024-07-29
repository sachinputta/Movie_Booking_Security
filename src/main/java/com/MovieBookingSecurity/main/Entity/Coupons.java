package com.MovieBookingSecurity.main.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupons {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long couponid;
	private String couponname;
	private int discountoffer;
	
	@ManyToOne
	@JsonBackReference
	public User user;
//	public Admin admin;
	
	
	

}
