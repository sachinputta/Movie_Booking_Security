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

import com.MovieBookingSecurity.main.Entity.Cards;
import com.MovieBookingSecurity.main.Entity.Coupons;
import com.MovieBookingSecurity.main.Entity.Movie;
import com.MovieBookingSecurity.main.Entity.RegisteredUser;
import com.MovieBookingSecurity.main.Entity.User;
import com.MovieBookingSecurity.main.service.RegisteredUserService;

import jakarta.annotation.PostConstruct;

@RestController
public class RegisteredUserController {

	@Autowired
	public RegisteredUserService registeredUserService;
	
	@PostConstruct
	public void addRoles() {
		registeredUserService.addRoles();
	}

	@PostMapping("/registerUser")
	public User registerUser(@RequestBody User user) {

		User r1 = registeredUserService.registerUser(user);
		return r1;
	}

	@PreAuthorize("hasRole('Customer')")
	@PutMapping("/updateRegisterUser")
	public User updateRegisterUser(@RequestParam String email, @RequestBody User user) {
		User r2 = registeredUserService.updateRegisterUser(email, user);
		return r2;
	}

	@DeleteMapping("/deleteRegisterUser")
	public String deleteRegisterUser(@RequestParam String email) {
		String r3 = registeredUserService.deleteRegisterUser(email);

		return r3;
	}

	@PreAuthorize("hasRole('Customer')")
	@GetMapping("/viewAllMovies")

	public List<Movie> viewAllMovies() {
		List<Movie> view_All_Movies = registeredUserService.viewAllMovies();

		return view_All_Movies;
	}

	@PreAuthorize("hasRole('Customer')")
	@GetMapping("/viewMovieByName")
	public List<Movie> viewMovieByName(@RequestParam String moviename) {
		List<Movie> view_All_By_Name = registeredUserService.viewMovieByName(moviename);

		return view_All_By_Name;

	}

	@PreAuthorize("hasRole('Customer')")
	@PostMapping("/addCards")
	public Cards addCards(@RequestParam String email, @RequestBody Cards cards) {

		Cards c1 = registeredUserService.addCards(email, cards);
		return c1;
	}

	@PreAuthorize("hasRole('Customer')")
	@PutMapping("/updateCards")
	public Cards updateCards(@RequestParam long cardid, @RequestBody Cards cards) {
		Cards c2 = registeredUserService.updateCards(cardid, cards);
		return c2;
	}

	@PreAuthorize("hasRole('Customer')")
	@DeleteMapping("/deleteCards")
	public String deleteCards(@RequestParam long cardid) {
		String c3 = registeredUserService.deleteCards(cardid);

		return c3;
	}

	@PreAuthorize("hasRole('Customer')")
	@GetMapping("/availableBalance")
	public float availableBalance(@RequestParam String email, long cardid) {
		float balance = registeredUserService.availableBalance(email, cardid);

		return balance;

	}

	@PreAuthorize("hasRole('Customer')")
	@GetMapping("/viewSeatAvailable")
	public int viewSeatAvailable(@RequestParam String movieid, long showid) {
		int balance = registeredUserService.viewSeatAvailable(movieid, showid);

		return balance;

	}

	@PreAuthorize("hasRole('Customer')")
	@GetMapping("/viewAllCoupons")

	public List<Coupons> viewAllCoupons() {
		List<Coupons> view_All_Coupons = registeredUserService.viewAllCoupons();

		return view_All_Coupons;
	}

}
