package com.MovieBookingSecurity.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MovieBookingSecurity.main.Entity.Admin;
import com.MovieBookingSecurity.main.Entity.Coupons;
import com.MovieBookingSecurity.main.Entity.Movie;
import com.MovieBookingSecurity.main.Entity.MovieShows;
import com.MovieBookingSecurity.main.exception.ResourceNotFoundException;
import com.MovieBookingSecurity.main.repository.AdminRepository;
import com.MovieBookingSecurity.main.repository.CouponsRepository;
import com.MovieBookingSecurity.main.repository.MovieRepository;
import com.MovieBookingSecurity.main.repository.MovieShowsRepository;
import com.MovieBookingSecurity.main.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	public AdminRepository adminRepository;

	@Autowired
	public MovieRepository movieRepository;

	@Autowired
	public MovieShowsRepository movieShowsRepository;

	@Autowired
	public CouponsRepository couponsRepository;

	@Override
	public Admin addAdmin(Admin admin) {
		Admin a1 = adminRepository.findById(admin.getAdminid()).orElse(new Admin());

		a1.setAdminid(admin.getAdminid());
		a1.setFullname(admin.getFullname());
		a1.setPassword(admin.getPassword());
		a1.setEmail(admin.getEmail());
		a1.setAddress(admin.getAddress());
		a1.setMobileno(admin.getMobileno());
		return adminRepository.save(a1);
	}

	@Override
	public Admin updateAdmin(long adminid, Admin admin) {
		Admin t1 = adminRepository.findById(adminid)
				.orElseThrow(() -> new ResourceNotFoundException("Admin-ID is not found...!! : " + adminid));

		t1.setEmail(admin.getEmail());
		t1.setAddress(admin.getAddress());
		t1.setMobileno(admin.getMobileno());
		return adminRepository.save(t1);
	}

	@Override
	public String deleteAdmin(long adminid) {
		Admin d1 = adminRepository.findById(adminid)
				.orElseThrow(() -> new ResourceNotFoundException("Admin-ID is not found...!! : " + adminid));
		adminRepository.delete(d1);
		return "Admin Deleted Successfully.... (AdminId : " + adminid + ")";
	}

	@Override
	public Movie addMovie(long adminid, Movie movie) {
		Admin t1 = adminRepository.findById(adminid)
				.orElseThrow(() -> new ResourceNotFoundException("Admin-ID is not found...!! : " + adminid));
		Movie m1 = movieRepository.findById(movie.getMovieid()).orElse(new Movie());

		m1.setMovieid(movie.getMovieid());
		m1.setMoviename(movie.getMoviename());
		m1.setVenue(movie.getVenue());

		return movieRepository.save(m1);
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
	public MovieShows addShows(long adminid, String movieid, MovieShows movieShows) {
		Admin t1 = adminRepository.findById(adminid)
				.orElseThrow(() -> new ResourceNotFoundException("Admin-ID is not found...!! : " + adminid));
		Movie m3 = movieRepository.findById(movieid)
				.orElseThrow(() -> new ResourceNotFoundException("Movie-ID is not found...!! : " + movieid));

		MovieShows s1 = movieShowsRepository.findById(movieShows.getShowid()).orElse(new MovieShows());

		s1.setShowid(movieShows.getShowid());
		s1.setShowname(movieShows.getShowname());
		s1.setShowdate(movieShows.getShowdate());
		s1.setShowtime(movieShows.getShowtime());
		s1.setAvailableseats(movieShows.getAvailableseats());
		s1.setMovie(m3);
		return movieShowsRepository.save(s1);
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
	public Coupons addCoupons(long adminid, Coupons coupons) {
		Admin t1 = adminRepository.findById(adminid)
				.orElseThrow(() -> new ResourceNotFoundException("Admin-ID is not found...!! : " + adminid));
		Coupons c1 = couponsRepository.findById(coupons.getCouponid()).orElse(new Coupons());
		c1.setCouponname(coupons.getCouponname());
		c1.setDiscountoffer(coupons.getDiscountoffer());
		c1.setAdmin(t1);
		return couponsRepository.save(c1);
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
