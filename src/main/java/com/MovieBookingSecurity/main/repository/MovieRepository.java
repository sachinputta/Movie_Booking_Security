package com.MovieBookingSecurity.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MovieBookingSecurity.main.Entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

	List<Movie> findByMoviename(String moviename);

}
