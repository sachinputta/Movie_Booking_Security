package com.MovieBookingSecurity.main.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MakePayment {
	 
	@Id
	private long paymentid;
	private long transactionid;
	private float amount;
	private boolean paymentstatus;
	
	@OneToOne
	private BookTicket bookTicket;
	

}
