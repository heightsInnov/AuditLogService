package com.babatunde.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import com.babatunde.model.CustomClient;
import com.babatunde.repository.ClientRepository;
import com.babatunde.response.ApiResponse;
import com.babatunde.service.ClientService;

@Primary
@Service
public class ClientServiceImpl implements ClientService,ClientDetailsService {
	
	@Autowired
	private ClientRepository clientRepo;

	@Override
	public ApiResponse addClient(CustomClient client) {
		ApiResponse response = new ApiResponse("Unable to process request right now");
		try {
			clientRepo.save(client);
			response.setCode(ApiResponse.SUCCESS);
			response.setMessage("Successfully registered application");
		}catch(Exception ex) {
			System.out.println("Error occured while saving application because: "+ex.getMessage());
			response.setCode(ApiResponse.EXCEPTIONOCCURED);
			response.setMessage("Error occured while saving application because: "+ex.getMessage());
		}
		return response;
	}

	@Override
	public List<CustomClient> findAllClients() {
		List<CustomClient> clients = new ArrayList<>();
		try {
			Iterator<CustomClient> iClients = clientRepo.findAll().iterator();
			while(iClients.hasNext())
				clients.add(iClients.next());
				
		}catch(Exception ex) {
			System.out.println("Error occured while trying to find all clients because: "+ex.getMessage());
		}
		return clients;
	}

	@Override
	public ApiResponse deleteClient(String clientId) {
		ApiResponse response = new ApiResponse("Unable to process request right now");
		try {
			clientRepo.deleteById(clientId);
			response.setCode(ApiResponse.SUCCESS);
			response.setMessage("Successfully deleted the client application");
		}catch(Exception ex) {
			System.out.println("Unable to delete client application right now because: "+ex.getMessage());
			response.setCode(ApiResponse.EXCEPTIONOCCURED);
			response.setMessage("Unable to delete client application right now because: "+ex.getMessage());
		}
		return response;
	}

	@Override
	public CustomClient findClient(String clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		CustomClient client = clientRepo.findById(clientId).get();
		if(client!=null)
			return client;
		else
			throw new ClientRegistrationException("The client details is invalid");
	}

}
