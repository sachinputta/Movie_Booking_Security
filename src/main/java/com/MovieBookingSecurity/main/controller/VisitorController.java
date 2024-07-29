package com.MovieBookingSecurity.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MovieBookingSecurity.main.Entity.Movie;
import com.MovieBookingSecurity.main.service.VisitorService;

@RestController
public class VisitorController {

	@Autowired
	public VisitorService visitorService;

	@GetMapping("/viewAllMoviesByVisitor")

	public List<Movie> viewAllMoviesByVisitor() {
		List<Movie> view_All_Movies = visitorService.viewAllMoviesByVisitor();

		return view_All_Movies;
	}
}
