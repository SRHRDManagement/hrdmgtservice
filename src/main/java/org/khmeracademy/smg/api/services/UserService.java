package org.khmeracademy.smg.api.services;

import java.util.ArrayList;

import org.khmeracademy.smg.api.model.Role;
import org.khmeracademy.smg.api.model.User;

public interface UserService {
	public User findUserByEmail(String userEmail);
	public ArrayList<Role> findRolesByRoleId(int rol_id);
}
