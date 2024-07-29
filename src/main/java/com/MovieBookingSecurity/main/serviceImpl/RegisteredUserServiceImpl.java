package com.MovieBookingSecurity.main.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.MovieBookingSecurity.main.Entity.Cards;
import com.MovieBookingSecurity.main.Entity.Coupons;
import com.MovieBookingSecurity.main.Entity.Movie;
import com.MovieBookingSecurity.main.Entity.MovieShows;
import com.MovieBookingSecurity.main.Entity.Role;
import com.MovieBookingSecurity.main.Entity.User;
import com.MovieBookingSecurity.main.exception.ResourceNotFoundException;
import com.MovieBookingSecurity.main.repository.CardsRepository;
import com.MovieBookingSecurity.main.repository.CouponsRepository;
import com.MovieBookingSecurity.main.repository.MovieRepository;
import com.MovieBookingSecurity.main.repository.MovieShowsRepository;
import com.MovieBookingSecurity.main.repository.RoleRepository;
import com.MovieBookingSecurity.main.repository.UserRepository;
import com.MovieBookingSecurity.main.service.RegisteredUserService;

@Service
public class RegisteredUserServiceImpl implements RegisteredUserService {

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public MovieRepository movieRepository;

	@Autowired
	public CardsRepository cardsRepository;

	@Autowired
	public MovieShowsRepository movieShowsRepository;

	@Autowired
	public CouponsRepository couponsRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

	@Override
	public String addRoles() {
		Role adminRole = new Role();
		adminRole.setRolename("Admin");
		roleRepository.save(adminRole);

		Role customerRole = new Role();
		customerRole.setRolename("Customer");
		roleRepository.save(customerRole);

		Role visitorRole = new Role();
		visitorRole.setRolename("Visitor");
		roleRepository.save(visitorRole);

		return "Success";
	}

	@Override
	public User registerUser(User user) {
		Role role = roleRepository.findById("Customer")
				.orElseThrow(() -> new ResourceNotFoundException("Role is not found...!!"));
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRoles(roles);
		String encodedPassword = getEncodedPassword(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}

	@Override
	public User updateRegisterUser(String email, User user) {
		User r2 = userRepository.findById(email)
				.orElseThrow(() -> new ResourceNotFoundException("Register-ID is not found...!! : " + email));

		String encodedPassword = getEncodedPassword(user.getPassword());
		r2.setPassword(encodedPassword);
		r2.setName(user.getName());
		r2.setAddress(user.getAddress());
		r2.setPhoneno(user.getPhoneno());
		return userRepository.save(r2);
	}

	@Override
	public String deleteRegisterUser(String email) {
		User m3 = userRepository.findById(email)
				.orElseThrow(() -> new ResourceNotFoundException("Register-ID is not found...!! : " + email));
		userRepository.delete(m3);
		return "RegisterUser Deleted Successfully...... (RegisterId : " + email + ")";
	}

	@Override
	public List<Movie> viewAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public List<Movie> viewMovieByName(String moviename) {

		List<Movie> movie_name = movieRepository.findByMoviename(moviename);

		return movie_name;
	}

	@Override
	public Cards addCards(String email, Cards cards) {
		User m3 = userRepository.findById(email)
				.orElseThrow(() -> new ResourceNotFoundException("Register-ID is not found...!! : " + email));
		Cards c1 = cardsRepository.findById(cards.getCardid()).orElse(new Cards());

		c1.setCardname(cards.getCardname());
		c1.setCardno(cards.getCardno());
		c1.setCardtype(cards.getCardtype());
		c1.setAvailableamount(cards.getAvailableamount());
		c1.setUser(m3);
		return cardsRepository.save(c1);
	}

	@Override
	public Cards updateCards(long cardid, Cards cards) {
		Cards c2 = cardsRepository.findById(cardid)
				.orElseThrow(() -> new ResourceNotFoundException("Card-ID is not found...!! : " + cardid));
		c2.setCardname(cards.getCardname());
		c2.setCardtype(cards.getCardtype());
		c2.setAvailableamount(cards.getAvailableamount());

		return cardsRepository.save(c2);
	}

	@Override
	public String deleteCards(long cardid) {
		Cards c3 = cardsRepository.findById(cardid)
				.orElseThrow(() -> new ResourceNotFoundException("Card-ID is not found...!! : " + cardid));
		cardsRepository.delete(c3);
		return "Cards Deleted Successfully...... (CardId : " + cardid + ")";
	}

	@Override
	public float availableBalance(String email, long cardid) {
		Cards c4 = cardsRepository.findByEmailAndCardId(email, cardid);
		if (c4 == null) {
			throw new ResourceNotFoundException("RegisterId and CardId is not matching...!! : ");
		}
		return c4.getAvailableamount();
	}

	@Override
	public int viewSeatAvailable(String movieid, long showid) {

		MovieShows z1 = movieShowsRepository.findByMovieIdAndShowId(movieid, showid);
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
