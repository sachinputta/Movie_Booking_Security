package com.MovieBookingSecurity.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MovieBookingSecurity.main.Entity.Visitor;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {

}
