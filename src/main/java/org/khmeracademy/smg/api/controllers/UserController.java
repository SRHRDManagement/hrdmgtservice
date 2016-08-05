package org.khmeracademy.smg.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.smg.api.model.input.UserLogin;
import org.khmeracademy.smg.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
			System.out.println("vansar");
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
}
