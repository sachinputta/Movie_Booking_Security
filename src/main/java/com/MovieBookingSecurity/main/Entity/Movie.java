package com.MovieBookingSecurity.main.Entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
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
public class Movie {
	

	@Id
	private String movieid;
	private String moviename;
	private String venue;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
			mappedBy = "movie")
	private List<BookTicket> bookTicket;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
			mappedBy = "movie")
	@JsonManagedReference
	private List<MovieShows> movieShows;
	
}
