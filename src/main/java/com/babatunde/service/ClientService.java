package com.babatunde.service;

import java.util.List;

import com.babatunde.model.CustomClient;
import com.babatunde.response.ApiResponse;

public interface ClientService {
	
	public ApiResponse addClient(CustomClient client);
	
	public List<CustomClient> findAllClients();
	
	public ApiResponse deleteClient(String clientId);
	
	public CustomClient findClient(String clientId);

}
