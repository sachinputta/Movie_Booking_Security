package com.MovieBookingSecurity.main.service;

import java.util.List;

import com.MovieBookingSecurity.main.Entity.Cards;
import com.MovieBookingSecurity.main.Entity.Coupons;
import com.MovieBookingSecurity.main.Entity.Movie;
import com.MovieBookingSecurity.main.Entity.RegisteredUser;

public interface RegisteredUserService {

	// Register User............//

	public RegisteredUser registerUser(RegisteredUser registeredUser);

	public RegisteredUser updateRegisterUser(long registerid, RegisteredUser registeredUser);

	public String deleteRegisterUser(long registerid);

	public List<Movie> viewAllMovies();

	public List<Movie> viewMovieByName(String moviename);

	// Cards................//

	public Cards addCards(long registerid, Cards cards);

	public Cards updateCards(long cardid, Cards cards);

	public String deleteCards(long cardid);

	public float availableBalance(long registerid, long cardid);

	public int viewSeatAvailable(String movieid, long showid);

	public List<Coupons> viewAllCoupons();
}
