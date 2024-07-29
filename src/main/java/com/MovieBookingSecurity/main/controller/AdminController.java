package com.MovieBookingSecurity.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MovieBookingSecurity.main.Entity.Admin;
import com.MovieBookingSecurity.main.Entity.Coupons;
import com.MovieBookingSecurity.main.Entity.Movie;
import com.MovieBookingSecurity.main.Entity.MovieShows;
import com.MovieBookingSecurity.main.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	public AdminService adminService;

	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin) {

		Admin t1 = adminService.addAdmin(admin);
		return t1;
	}

	@PutMapping("/updateAdmin")
	public Admin updateAdmin(@RequestParam long adminid, @RequestBody Admin admin) {

		Admin admin_update = adminService.updateAdmin(adminid, admin);
		return admin_update;
	}

	@DeleteMapping("/deleteAdmin")
	public String deleteAdmin(@RequestParam long adminid) {
		String delete_admin = adminService.deleteAdmin(adminid);

		return delete_admin;
	}

	@PostMapping("/addMovie")
	public Movie addMovie(@RequestParam long adminid, @RequestBody Movie movie) {

		Movie m1 = adminService.addMovie(adminid, movie);
		return m1;

	}

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

	@GetMapping("/viewAllMoviesByAdmin")

	public List<Movie> viewAllMoviesByAdmin() {
		List<Movie> view_All_Movies = adminService.viewAllMoviesByAdmin();

		return view_All_Movies;
	}

	@GetMapping("/viewMovieById")

	public Movie viewMovieById(@RequestParam String movieid) {
		Movie view_MovieById = adminService.viewMovieById(movieid);

		return view_MovieById;

	}

	@PostMapping("/addShows")
	public MovieShows addShows(@RequestParam long adminid, String movieid, @RequestBody MovieShows movieShows) {

		MovieShows m4 = adminService.addShows(adminid, movieid, movieShows);
		return m4;

	}

	@PutMapping("/updateShows")
	public MovieShows updateShows(@RequestParam long showid, @RequestBody MovieShows movieShows) {

		MovieShows shows_update = adminService.updateShows(showid, movieShows);
		return shows_update;
	}

	@DeleteMapping("/deleteShows")
	public String deleteShows(@RequestParam long showid) {
		String delete_show = adminService.deleteShows(showid);

		return delete_show;
	}

	@PostMapping("/addCoupons")
	public Coupons addCoupons(@RequestParam long adminid, @RequestBody Coupons coupons) {

		Coupons c5 = adminService.addCoupons(adminid, coupons);
		return c5;

	}

	@PutMapping("/updateCoupons")
	public Coupons updateCoupons(@RequestParam long couponid, @RequestBody Coupons coupons) {

		Coupons coupon_update = adminService.updateCoupons(couponid, coupons);
		return coupon_update;
	}

	@DeleteMapping("/deleteCoupons")
	public String deleteCoupons(@RequestParam long couponid) {
		String delete_coupon = adminService.deleteCoupons(couponid);

		return delete_coupon;
	}

}
