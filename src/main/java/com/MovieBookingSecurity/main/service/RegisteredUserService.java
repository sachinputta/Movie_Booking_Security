package com.MovieBookingSecurity.main.service;

import java.util.List;

import com.MovieBookingSecurity.main.Entity.Cards;
import com.MovieBookingSecurity.main.Entity.Coupons;
import com.MovieBookingSecurity.main.Entity.Movie;
import com.MovieBookingSecurity.main.Entity.RegisteredUser;
import com.MovieBookingSecurity.main.Entity.User;

public interface RegisteredUserService {

	// Register User............//

	public String addRoles();

	public User registerUser(User user);

	public User updateRegisterUser(String email, User user);

	public String deleteRegisterUser(String email);

	public List<Movie> viewAllMovies();

	public List<Movie> viewMovieByName(String moviename);

	// Cards................//

	public Cards addCards(String email, Cards cards);

	public Cards updateCards(long cardid, Cards cards);

	public String deleteCards(long cardid);

	public float availableBalance(String email, long cardid);

	public int viewSeatAvailable(String movieid, long showid);

	public List<Coupons> viewAllCoupons();
}
