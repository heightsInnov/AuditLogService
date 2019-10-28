package com.babatunde.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.babatunde.model.User;
import com.babatunde.repository.UserRepository;
import com.babatunde.service.UserService;

@Service
public class UserServiceImpl implements UserService,UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = userRepo.findByUsername(username);
		if(u!=null) {
			return u;
		}else {
			throw new UsernameNotFoundException("Username not found");
		}
	}
	

	@Override
	public User addUser(User user) {
		User u = null;
		try {
			user.setPassword(user.getPassword());
			u = userRepo.save(user);
		}catch(Exception ex) {
			System.out.println("Error occured while adding new user because: "+ex.getMessage());
		}
		return u;
	}

	@Override
	public List<User> findAllUsers() {
		List<User> users = new ArrayList<>();
		try {
			Iterator<User> Iusers = userRepo.findAll().iterator();
			while(Iusers.hasNext())
				users.add(Iusers.next());
				
		}catch(Exception ex) {
			System.out.println("Error occured while trying to get all users because: "+ex.getMessage());
		}
		return users;
	}

	@Override
	public User findUserById(String id) {
		User user = null;
		try {
			Optional<User> optionalUser = userRepo.findById(id);
			if(optionalUser.isPresent())
				user = optionalUser.get();
		}catch(Exception ex) {
			System.out.println("Error while finding user by id because: "+ex.getMessage());
		}
		return user;
	}

}
