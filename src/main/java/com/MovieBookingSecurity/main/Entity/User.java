package com.MovieBookingSecurity.main.Entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String email;
	private String password;
	private String name;
	private String address;
	private long phoneno;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
			mappedBy = "user")
	@JsonManagedReference
	private List<Coupons> coupons;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
			mappedBy = "user")
	private List<BookTicket> bookTicket;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
			mappedBy = "user")
	@JsonManagedReference
	private List<Cards> cards;
	

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "User_Roles", joinColumns = { @JoinColumn(name = "User_id") }, inverseJoinColumns = {
			@JoinColumn(name = "Role_Name") })
	private Set<Role> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> authorities = new HashSet<>();
		this.roles.forEach(userRole -> {
			authorities.add(new Authority("ROLE_" + userRole.getRolename()));
		});
		return authorities;
	}

	@Override
	public String getUsername() {

		return this.email;
	}

}
