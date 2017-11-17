package cz.expertkom.ju.springdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.expertkom.ju.interfaces.UserRepository;
import cz.expertkom.ju.interfaces.UserService;
import cz.expertkom.ju.interfaces.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User getUser(String username) {
		return userRepository.getUser(username);
	}

}
