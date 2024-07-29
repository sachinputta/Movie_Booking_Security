package com.MovieBookingSecurity.main.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.annotation.Generated;
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
public class MovieShows {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long showid;
	private String showname;
	private LocalDate showdate;
	private LocalTime showtime;
	private int availableseats;
	
	@ManyToOne
	@JsonBackReference
	public Movie movie;
	

}
