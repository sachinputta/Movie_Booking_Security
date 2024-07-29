package com.MovieBookingSecurity.main.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.MovieBookingSecurity.main.Entity.Coupons;
import com.MovieBookingSecurity.main.Entity.Movie;
import com.MovieBookingSecurity.main.Entity.MovieShows;
import com.MovieBookingSecurity.main.Entity.Role;
import com.MovieBookingSecurity.main.Entity.User;
import com.MovieBookingSecurity.main.exception.ResourceNotFoundException;
import com.MovieBookingSecurity.main.repository.CouponsRepository;
import com.MovieBookingSecurity.main.repository.MovieRepository;
import com.MovieBookingSecurity.main.repository.MovieShowsRepository;
import com.MovieBookingSecurity.main.repository.RoleRepository;
import com.MovieBookingSecurity.main.repository.UserRepository;
import com.MovieBookingSecurity.main.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public MovieRepository movieRepository;

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
	public User addAdmin(User user) {
		Role role = roleRepository.findById("Admin")
				.orElseThrow(() -> new ResourceNotFoundException("Role not found...!!"));
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRoles(roles);
		String encodedPassword = getEncodedPassword(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}

	@Override
	public User updateAdmin(String email, User user) {
		User t1 = userRepository.findById(email)
				.orElseThrow(() -> new ResourceNotFoundException("Admin Email-ID is not found...!! : " + email));

		String encodedPassword = getEncodedPassword(user.getPassword());
		t1.setPassword(encodedPassword);
		t1.setName(user.getName());
		t1.setAddress(user.getAddress());
		t1.setPhoneno(user.getPhoneno());
		return userRepository.save(t1);
	}

	@Override
	public String deleteAdmin(String email) {
		User d1 = userRepository.findById(email)
				.orElseThrow(() -> new ResourceNotFoundException("Admin-ID is not found...!! : " + email));
		userRepository.delete(d1);
		return "Dealer Deleted Successfully....!!! (Admin-ID : " + email + ")";
	}

	@Override
	public Movie addMovie(String email, Movie movie) {
		User t1 = userRepository.findById(email)
				.orElseThrow(() -> new ResourceNotFoundException("Admin-ID is not found...!! : " + email));

		return movieRepository.save(movie);
	}

	@Override
	public Movie updateMovie(String movieid, Movie movie) {
		Movie m2 = movieRepository.findById(movieid)
				.orElseThrow(() -> new ResourceNotFoundException("Movie-ID is not found...!! : " + movieid));

		m2.setMoviename(movie.getMoviename());
		m2.setVenue(movie.getVenue());
		return movieRepository.save(m2);
	}

	@Override
	public String deleteMovie(String movieid) {
		Movie m3 = movieRepository.findById(movieid)
				.orElseThrow(() -> new ResourceNotFoundException("Movie-ID is not found...!! : " + movieid));
		movieRepository.delete(m3);
		return "Movie Deleted Successfully...... (MovieId : " + movieid + ")";
	}

	@Override
	public List<Movie> viewAllMoviesByAdmin() {
		return movieRepository.findAll();
	}

	@Override
	public Movie viewMovieById(String movieid) {
		return movieRepository.findById(movieid).orElseThrow(
				() -> new ResourceNotFoundException("Movie-ID is not found...(MovieId : " + movieid + ")"));
	}

	@Override
	public MovieShows addShows(String email, String movieid, MovieShows movieShows) {
		User t1 = userRepository.findById(email)
				.orElseThrow(() -> new ResourceNotFoundException("Admin-ID is not found...!! : " + email));
		Movie m3 = movieRepository.findById(movieid)
				.orElseThrow(() -> new ResourceNotFoundException("Movie-ID is not found...!! : " + movieid));
		movieShows.setMovie(m3);
		return movieShowsRepository.save(movieShows);
	}

	@Override
	public MovieShows updateShows(long showid, MovieShows movieShows) {
		MovieShows s2 = movieShowsRepository.findById(showid)
				.orElseThrow(() -> new ResourceNotFoundException("Show-ID is not found...!! : " + showid));

		s2.setShowname(movieShows.getShowname());
		s2.setShowdate(movieShows.getShowdate());
		s2.setShowtime(movieShows.getShowtime());
		s2.setAvailableseats(movieShows.getAvailableseats());
		return movieShowsRepository.save(s2);
	}

	@Override
	public String deleteShows(long showid) {
		MovieShows s3 = movieShowsRepository.findById(showid)
				.orElseThrow(() -> new ResourceNotFoundException("Show-ID is not found...!! : " + showid));
		movieShowsRepository.delete(s3);
		return "Movie Deleted Successfully...... (MovieId : " + showid + ")";
	}

	@Override
	public Coupons addCoupons(String email, Coupons coupons) {
		User t1 = userRepository.findById(email)
				.orElseThrow(() -> new ResourceNotFoundException("Admin-ID is not found...!! : " + email));
		Coupons c1 = couponsRepository.findById(coupons.getCouponid()).orElse(new Coupons());
//		c1.setCouponname(coupons.getCouponname());
//		c1.setDiscountoffer(coupons.getDiscountoffer());
		coupons.setUser(t1);
		return couponsRepository.save(coupons);
	}

	@Override
	public Coupons updateCoupons(long couponid, Coupons coupons) {
		Coupons c2 = couponsRepository.findById(couponid)
				.orElseThrow(() -> new ResourceNotFoundException("Coupon-ID is not found...!! : " + couponid));
		c2.setCouponname(coupons.getCouponname());
		c2.setDiscountoffer(coupons.getDiscountoffer());
		return couponsRepository.save(c2);
	}

	@Override
	public String deleteCoupons(long couponid) {
		Coupons c3 = couponsRepository.findById(couponid)
				.orElseThrow(() -> new ResourceNotFoundException("Coupon-ID is not found...!! : " + couponid));
		couponsRepository.delete(c3);
		return "Coupons Deleted Successfully.... (CouponId : " + couponid + ")";
	}

}
