package com.babatunde.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.babatunde.model.CustomClient;

@Repository
public interface ClientRepository extends CrudRepository<CustomClient, String> {

}
