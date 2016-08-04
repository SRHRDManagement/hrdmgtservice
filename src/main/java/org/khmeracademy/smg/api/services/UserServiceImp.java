package org.khmeracademy.smg.api.services;

import java.util.ArrayList;

import org.khmeracademy.smg.api.model.Role;
import org.khmeracademy.smg.api.model.User;
import org.khmeracademy.smg.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findUserByEmail(String userEmail) {
		return userRepository.findUserByEmail(userEmail);
	}

	@Override
	public ArrayList<Role> findRolesByRoleId(int rol_id) {
		return userRepository.findRolesByRoleId(rol_id);
	}

}
