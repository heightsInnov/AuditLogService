package com.jumia.pay.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jumia.pay.model.BasicClientDetails;

@Repository
public interface ClientDetailsRepository extends PagingAndSortingRepository<BasicClientDetails, String>{

	public BasicClientDetails findByClientId(String clientId);
	
}
