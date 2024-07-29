package com.MovieBookingSecurity.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MovieBookingSecurity.main.Entity.Coupons;

@Repository
public interface CouponsRepository extends JpaRepository<Coupons, Long> {

}
