package org.khmeracademy.smg.api.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.khmeracademy.smg.api.model.EnrollStaff;
import org.khmeracademy.smg.api.services.EnrollStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/enroll-instructor")
public class EnrollStaffController {
	
	@Autowired
	private EnrollStaffService service;
	
	// insert class in each course *
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addClass(@RequestBody EnrollStaff enrollStaff){
		Map<String, Object> map = new HashMap<>();
		try {
			if(service.addEnrollStaff(enrollStaff)){
				map.put("MESSAGE", "Enroll instructor successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not enroll instructor!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	// get all information of instructor
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getInstructor(){
		Map<String, Object> map = new HashMap<>();
		ArrayList<EnrollStaff> list = service.getInstructor();
		try {
			if(!list.isEmpty()){
				map.put("DATA", list);
				map.put("MESSAGE", "Get instructor successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not get instructor!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	// get all information of instructor by generation
	@RequestMapping(value="/{gen_id}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getInstructorByGenerationAndClass(@PathVariable int gen_id){
		EnrollStaff enrollStaff = new EnrollStaff();
		enrollStaff.setGen_id(gen_id);
		Map<String, Object> map = new HashMap<>();
		ArrayList<EnrollStaff> list = service.getInstructorByGeneration(enrollStaff);
		try {
			if(!list.isEmpty()){
				map.put("DATA", list);
				map.put("MESSAGE", "Get instructor successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not get instructor!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	// remove instructor
	@RequestMapping(value="/{sp_id}", method=RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> removeInstructor(@PathVariable int sp_id){
		Map<String, Object> map = new HashMap<>();
		try {
			if(service.removeInstructor(sp_id)){
				map.put("MESSAGE", "Get instructor successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not get instructor!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}

}
