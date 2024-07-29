package com.MovieBookingSecurity.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MovieBookingSecurity.main.Entity.Movie;
import com.MovieBookingSecurity.main.repository.MovieRepository;
import com.MovieBookingSecurity.main.service.VisitorService;



@Service
public class VisitorServiceImpl implements VisitorService {
	
	@Autowired
	public MovieRepository movieRepository;
	
	
	@Override
	public List<Movie> viewAllMoviesByVisitor() {
		return movieRepository.findAll();
	}


}
