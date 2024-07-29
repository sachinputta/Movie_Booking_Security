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

import com.MovieBookingSecurity.main.Entity.Cards;
import com.MovieBookingSecurity.main.Entity.Coupons;
import com.MovieBookingSecurity.main.Entity.Movie;
import com.MovieBookingSecurity.main.Entity.RegisteredUser;
import com.MovieBookingSecurity.main.service.RegisteredUserService;

@RestController
public class RegisteredUserController {

	@Autowired
	public RegisteredUserService registeredUserService;

	@PostMapping("/registerUser")
	public RegisteredUser registerUser(@RequestBody RegisteredUser registeredUser) {

		RegisteredUser r1 = registeredUserService.registerUser(registeredUser);
		return r1;
	}

	@PutMapping("/updateRegisterUser")
	public RegisteredUser updateRegisterUser(@RequestParam long registerid,
			@RequestBody RegisteredUser registeredUser) {
		RegisteredUser r2 = registeredUserService.updateRegisterUser(registerid, registeredUser);
		return r2;
	}

	@DeleteMapping("/deleteRegisterUser")
	public String deleteRegisterUser(@RequestParam long registerid) {
		String r3 = registeredUserService.deleteRegisterUser(registerid);

		return r3;
	}

	@GetMapping("/viewAllMovies")

	public List<Movie> viewAllMovies() {
		List<Movie> view_All_Movies = registeredUserService.viewAllMovies();

		return view_All_Movies;
	}

	@GetMapping("/viewMovieByName")
	public List<Movie> viewMovieByName(@RequestParam String moviename) {
		List<Movie> view_All_By_Name = registeredUserService.viewMovieByName(moviename);

		return view_All_By_Name;

	}

	@PostMapping("/addCards")
	public Cards addCards(@RequestParam long registerid, @RequestBody Cards cards) {

		Cards c1 = registeredUserService.addCards(registerid, cards);
		return c1;
	}

	@PutMapping("/updateCards")
	public Cards updateCards(@RequestParam long cardid, @RequestBody Cards cards) {
		Cards c2 = registeredUserService.updateCards(cardid, cards);
		return c2;
	}

	@DeleteMapping("/deleteCards")
	public String deleteCards(@RequestParam long cardid) {
		String c3 = registeredUserService.deleteCards(cardid);

		return c3;
	}

	@GetMapping("/availableBalance")
	public float availableBalance(@RequestParam long registerid, long cardid) {
		float balance = registeredUserService.availableBalance(registerid, cardid);

		return balance;

	}

	@GetMapping("/viewSeatAvailable")
	public int viewSeatAvailable(@RequestParam String movieid, long showid) {
		int balance = registeredUserService.viewSeatAvailable(movieid, showid);

		return balance;

	}

	@GetMapping("/viewAllCoupons")

	public List<Coupons> viewAllCoupons() {
		List<Coupons> view_All_Coupons = registeredUserService.viewAllCoupons();

		return view_All_Coupons;
	}

}
