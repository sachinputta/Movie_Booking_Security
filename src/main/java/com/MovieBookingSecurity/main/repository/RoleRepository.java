package com.MovieBookingSecurity.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MovieBookingSecurity.main.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
