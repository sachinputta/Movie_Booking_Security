package com.MovieBookingSecurity.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MovieBookingSecurity.main.Entity.MovieShows;

@Repository
public interface MovieShowsRepository extends JpaRepository<MovieShows, Long> {

	@Query("SELECT ms FROM MovieShows ms WHERE ms.movie.movieid = :movieid AND ms.showid = :showid")

	MovieShows findByMovieIdAndShowId(@Param("movieid") String movieid, @Param("showid") Long showid);

}
