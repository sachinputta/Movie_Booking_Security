package com.MovieBookingSecurity.main.Entity;

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
public class BookTicket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingid;
	private boolean bookingstatus;
	private int quantity;
	private String seatno;
	private float ticketPrice; 

	@ManyToOne
	@JoinColumn(name = "user_registerid")
//	private RegisteredUser registeredUser;
	private User user;
	
	@ManyToOne
	private Movie movie;

}
