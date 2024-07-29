package com.MovieBookingSecurity.main.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cards {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cardid;
	private String cardname;
	private long cardno;
	private String cardtype;
	private float availableamount;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "registered_user_registerid")
	private RegisteredUser registeredUser;
	
}
