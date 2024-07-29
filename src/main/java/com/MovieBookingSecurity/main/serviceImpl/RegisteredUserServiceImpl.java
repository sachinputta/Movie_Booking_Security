package com.MovieBookingSecurity.main.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MovieBookingSecurity.main.Entity.Cards;
import com.MovieBookingSecurity.main.Entity.Coupons;
import com.MovieBookingSecurity.main.Entity.Movie;
import com.MovieBookingSecurity.main.Entity.MovieShows;
import com.MovieBookingSecurity.main.Entity.RegisteredUser;
import com.MovieBookingSecurity.main.exception.ResourceNotFoundException;
import com.MovieBookingSecurity.main.repository.CardsRepository;
import com.MovieBookingSecurity.main.repository.CouponsRepository;
import com.MovieBookingSecurity.main.repository.MovieRepository;
import com.MovieBookingSecurity.main.repository.MovieShowsRepository;
import com.MovieBookingSecurity.main.repository.RegisteredUserRepository;
import com.MovieBookingSecurity.main.service.RegisteredUserService;




@Service
public class RegisteredUserServiceImpl implements RegisteredUserService {

	@Autowired
	public RegisteredUserRepository registeredUserRepository;

	@Autowired
	public MovieRepository movieRepository;
	
	@Autowired
	public CardsRepository cardsRepository;
	
	@Autowired
	public MovieShowsRepository movieShowsRepository;
	
	@Autowired
	public CouponsRepository couponsRepository;
	

	@Override
	public RegisteredUser registerUser(RegisteredUser registeredUser) {
		RegisteredUser r1 = registeredUserRepository.findById(registeredUser.getRegisterid())
				.orElse(new RegisteredUser());

		r1.setVisitorid(registeredUser.getVisitorid());
		r1.setFullname(registeredUser.getFullname());
		r1.setMobileno(registeredUser.getMobileno());
		r1.setAddress(registeredUser.getAddress());
		r1.setRegisterid(registeredUser.getVisitorid());
		r1.setPassword(registeredUser.getPassword());
		r1.setEmail(registeredUser.getEmail());

		return registeredUserRepository.save(r1);
	}

	@Override
	public RegisteredUser updateRegisterUser(long registerid, RegisteredUser registeredUser) {
		RegisteredUser r2 = registeredUserRepository.findById(registerid)
				.orElseThrow(() -> new ResourceNotFoundException("Register-ID is not found...!! : " + registerid));

		r2.setFullname(registeredUser.getFullname());
		r2.setMobileno(registeredUser.getMobileno());
		r2.setAddress(registeredUser.getAddress());
		r2.setEmail(registeredUser.getEmail());

		return registeredUserRepository.save(r2);
	}

	@Override
	public String deleteRegisterUser(long registerid) {
		RegisteredUser m3 = registeredUserRepository.findById(registerid)
				.orElseThrow(() -> new ResourceNotFoundException("Register-ID is not found...!! : " + registerid));
		registeredUserRepository.delete(m3);
		return "RegisterUser Deleted Successfully...... (RegisterId : " + registerid + ")";
	}


	@Override
	public List<Movie> viewAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public  List<Movie> viewMovieByName(String moviename) {
		
			List<Movie> movie_name = movieRepository.findByMoviename(moviename);

			return movie_name;
		}

	@Override
	public Cards addCards(long registerid, Cards cards) {
		RegisteredUser m3 = registeredUserRepository.findById(registerid)
				.orElseThrow(() -> new ResourceNotFoundException("Register-ID is not found...!! : " + registerid));
		Cards c1 = cardsRepository.findById(cards.getCardid()).orElse(new Cards());
		
		c1.setCardname(cards.getCardname());
		c1.setCardno(cards.getCardno());
		c1.setCardtype(cards.getCardtype());
		c1.setAvailableamount(cards.getAvailableamount());
		c1.setRegisteredUser(m3);
		return cardsRepository.save(c1);
	}

	@Override
	public Cards updateCards(long cardid, Cards cards) {
		Cards c2 = cardsRepository.findById(cardid)
				.orElseThrow(() -> new ResourceNotFoundException("Card-ID is not found...!! : " +cardid));
		c2.setCardname(cards.getCardname());
		c2.setCardtype(cards.getCardtype());
		c2.setAvailableamount(cards.getAvailableamount());
		
		return cardsRepository.save(c2);
	}

	@Override
	public String deleteCards(long cardid) {
		Cards c3 = cardsRepository.findById(cardid)
				.orElseThrow(() -> new ResourceNotFoundException("Card-ID is not found...!! : " +cardid));
		cardsRepository.delete(c3);
		return "Cards Deleted Successfully...... (CardId : " + cardid + ")";
	}

	@Override
	public float availableBalance(long registerid, long cardid) {
		Cards c4 = cardsRepository.findByRegisterIdAndCardId(registerid, cardid);
		if (c4 == null) {
			throw new ResourceNotFoundException("RegisterId and CardId is not matching...!! : ");
		}
		return c4.getAvailableamount();
	}

	@Override
	public int viewSeatAvailable(String movieid, long showid) {
		
		MovieShows z1 = movieShowsRepository.findByMovieIdAndShowId(movieid,showid);
		if (z1 == null) {
			throw new ResourceNotFoundException("MovieId and ShowId is not matching...!! : ");
		}
		return z1.getAvailableseats();
		
	}

	@Override
	public List<Coupons> viewAllCoupons() {
		return couponsRepository.findAll();
	}
	
	}



