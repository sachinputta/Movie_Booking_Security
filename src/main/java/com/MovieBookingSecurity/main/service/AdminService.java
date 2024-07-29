package com.MovieBookingSecurity.main.service;

import java.util.List;

import com.MovieBookingSecurity.main.Entity.Admin;
import com.MovieBookingSecurity.main.Entity.Coupons;
import com.MovieBookingSecurity.main.Entity.Movie;
import com.MovieBookingSecurity.main.Entity.MovieShows;
import com.MovieBookingSecurity.main.Entity.User;

public interface AdminService {

	// Admin................//
	
	public String addRoles();

	public User addAdmin(User user);

	public User updateAdmin(String email, User user);

	public String deleteAdmin(String email);

	// Movies................//

	public Movie addMovie(String email, Movie movie);

	public Movie updateMovie(String movieid, Movie movie);

	public String deleteMovie(String movieid);

	public List<Movie> viewAllMoviesByAdmin();

	public Movie viewMovieById(String movieid);

	// MovieShows................//

	public MovieShows addShows(String email, String movieid, MovieShows movieShows);

	public MovieShows updateShows(long showid, MovieShows movieShows);

	public String deleteShows(long showid);

	// Coupons................//

	public Coupons addCoupons(String email, Coupons coupons);

	public Coupons updateCoupons(long couponid, Coupons coupons);

	public String deleteCoupons(long couponid);

}
