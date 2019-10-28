package com.babatunde.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.babatunde.model.Role;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, String> {

	public Role findByName(String name);
}
