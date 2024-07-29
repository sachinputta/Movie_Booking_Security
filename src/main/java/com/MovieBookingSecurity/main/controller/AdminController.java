package com.MovieBookingSecurity.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.MovieBookingSecurity.main.Entity.Coupons;
import com.MovieBookingSecurity.main.Entity.Movie;
import com.MovieBookingSecurity.main.Entity.MovieShows;
import com.MovieBookingSecurity.main.Entity.User;
import com.MovieBookingSecurity.main.service.AdminService;

import jakarta.annotation.PostConstruct;

@RestController
public class AdminController {

	@Autowired
	public AdminService adminService;

	@PostConstruct
	public void addRoles() {
		adminService.addRoles();
	}
	
	@PostMapping("/addAdmin")
	public User addAdmin(@RequestBody User user) {

		User t1 = adminService.addAdmin(user);
		return t1;
	}

	@PreAuthorize("hasRole('Admin')")
	@PutMapping("/updateAdmin")
	public User updateAdmin(@RequestParam String email, @RequestBody User user) {

		User admin_update = adminService.updateAdmin(email, user);
		return admin_update;
	}

	@PreAuthorize("hasRole('Admin')")
	@DeleteMapping("/deleteAdmin")
	public String deleteAdmin(@RequestParam String email) {
		String delete_admin = adminService.deleteAdmin(email);

		return delete_admin;
	}

	@PreAuthorize("hasRole('Admin')")
	@PostMapping("/addMovie")
	public Movie addMovie(@RequestParam String email, @RequestBody Movie movie) {

		Movie m1 = adminService.addMovie(email, movie);
		return m1;

	}

	@PreAuthorize("hasRole('Admin')")
	@PutMapping("/updateMovie")
	public Movie updateMovie(@RequestParam String movieid, @RequestBody Movie movie) {

		Movie movie_update = adminService.updateMovie(movieid, movie);
		return movie_update;
	}

	@DeleteMapping("/deleteMovie")
	public String deleteMovie(@RequestParam String movieid) {
		String delete_movie = adminService.deleteMovie(movieid);

		return delete_movie;
	}

	@PreAuthorize("hasRole('Admin')")
	@GetMapping("/viewAllMoviesByAdmin")

	public List<Movie> viewAllMoviesByAdmin() {
		List<Movie> view_All_Movies = adminService.viewAllMoviesByAdmin();

		return view_All_Movies;
	}

	@PreAuthorize("hasRole('Admin')")
	@GetMapping("/viewMovieById")

	public Movie viewMovieById(@RequestParam String movieid) {
		Movie view_MovieById = adminService.viewMovieById(movieid);

		return view_MovieById;

	}

	@PreAuthorize("hasRole('Admin')")
	@PostMapping("/addShows")
	public MovieShows addShows(@RequestParam String email, String movieid, @RequestBody MovieShows movieShows) {

		MovieShows m4 = adminService.addShows(email, movieid, movieShows);
		return m4;

	}

	@PreAuthorize("hasRole('Admin')")
	@PutMapping("/updateShows")
	public MovieShows updateShows(@RequestParam long showid, @RequestBody MovieShows movieShows) {

		MovieShows shows_update = adminService.updateShows(showid, movieShows);
		return shows_update;
	}

	@PreAuthorize("hasRole('Admin')")
	@DeleteMapping("/deleteShows")
	public String deleteShows(@RequestParam long showid) {
		String delete_show = adminService.deleteShows(showid);

		return delete_show;
	}

	@PreAuthorize("hasRole('Admin')")
	@PostMapping("/addCoupons")
	public Coupons addCoupons(@RequestParam String email, @RequestBody Coupons coupons) {

		Coupons c5 = adminService.addCoupons(email, coupons);
		return c5;

	}

	@PreAuthorize("hasRole('Admin')")
	@PutMapping("/updateCoupons")
	public Coupons updateCoupons(@RequestParam long couponid, @RequestBody Coupons coupons) {

		Coupons coupon_update = adminService.updateCoupons(couponid, coupons);
		return coupon_update;
	}

	@PreAuthorize("hasRole('Admin')")
	@DeleteMapping("/deleteCoupons")
	public String deleteCoupons(@RequestParam long couponid) {
		String delete_coupon = adminService.deleteCoupons(couponid);

		return delete_coupon;
	}

}
