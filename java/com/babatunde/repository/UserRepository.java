package com.babatunde.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.babatunde.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String> {
	public User findByUsername(String username);
}
