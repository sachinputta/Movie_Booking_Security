package com.MovieBookingSecurity.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MovieBookingSecurity.main.Entity.Cards;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {

	@Query("SELECT cs FROM Cards cs WHERE cs.user.email = :email AND cs.cardid = :cardid")
	Cards findByEmailAndCardId(@Param("email") String  email, @Param("cardid") Long cardid);

//	@Query("SELECT cs FROM Cards cs WHERE cs.user.registerid = :registerid AND cs.cardid = :cardid")
//	Cards findByRegisterIdAndCardId(@Param("registerid") String  email, @Param("cardid") Long cardid);

}
