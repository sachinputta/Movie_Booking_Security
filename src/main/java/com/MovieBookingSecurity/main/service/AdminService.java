package com.MovieBookingSecurity.main.service;

import java.util.List;

import com.MovieBookingSecurity.main.Entity.Admin;
import com.MovieBookingSecurity.main.Entity.Coupons;
import com.MovieBookingSecurity.main.Entity.Movie;
import com.MovieBookingSecurity.main.Entity.MovieShows;

public interface AdminService {

	// Admin................//

	public Admin addAdmin(Admin admin);

	public Admin updateAdmin(long adminid, Admin admin);

	public String deleteAdmin(long adminid);

	// Movies................//

	public Movie addMovie(long adminid, Movie movie);

	public Movie updateMovie(String movieid, Movie movie);

	public String deleteMovie(String movieid);

	public List<Movie> viewAllMoviesByAdmin();

	public Movie viewMovieById(String movieid);

	// MovieShows................//

	public MovieShows addShows(long adminid, String movieid, MovieShows movieShows);

	public MovieShows updateShows(long showid, MovieShows movieShows);

	public String deleteShows(long showid);

	// Coupons................//

	public Coupons addCoupons(long adminid, Coupons coupons);

	public Coupons updateCoupons(long couponid, Coupons coupons);

	public String deleteCoupons(long couponid);

}
