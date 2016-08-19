package org.khmeracademy.smg.api.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.smg.api.model.User;
import org.khmeracademy.smg.api.model.input.UserLogin;
import org.khmeracademy.smg.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="find-user-by-email", method = RequestMethod.POST , headers = "Accept=application/json")
	public ResponseEntity<Map<String , Object>> findUserByEmail(@RequestBody UserLogin login){
		Map< String , Object> map = new HashMap<String , Object>();
		try{		
			map.put("STATUS",true);
			map.put("MESSAGE","Success");
			map.put("DATA", userService.findUserByEmail(login.getUsr_email()) );
			System.out.println(map);		
		}catch(Exception e){
			map.put("STATUS",false);
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
			System.out.println("vansar step over king");
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	//get all users
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Map<String , Object>> getAllUsers(){
		Map< String , Object> map = new HashMap<String , Object>();
		ArrayList<User> list = userService.getAllUsers();
		try{
			if(!list.isEmpty()){
				map.put("STATUS",true);
				map.put("MESSAGE","get all users successfully!");
				map.put("DATA", list);
			}else{
				map.put("STATUS",false);
				map.put("MESSAGE","can not get all users successfully!");
			}
		}catch(Exception e){
			map.put("STATUS",false);
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	//register new user
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Map<String , Object>> addUser(@RequestBody User user){
		Map< String , Object> map = new HashMap<String , Object>();
		try{
			if(userService.addUser(user)){
				map.put("STATUS",true);
				map.put("MESSAGE","Register user successfully!");
			}else{
				map.put("STATUS",false);
				map.put("MESSAGE","can not register user successfully!");
			}
		}catch(Exception e){
			map.put("STATUS",false);
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
}