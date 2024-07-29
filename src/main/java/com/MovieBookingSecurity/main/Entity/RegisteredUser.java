package com.MovieBookingSecurity.main.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisteredUser extends Visitor {
	
	private long registerid;
	private String password;
	private String email;
	
	
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
//			mappedBy = "registeredUser")
//	private List<BookTicket> bookTicket;
//	
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
//			mappedBy = "registeredUser")
//	@JsonManagedReference
//	private List<Cards> cards;

}
