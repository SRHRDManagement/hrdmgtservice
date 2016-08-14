package org.khmeracademy.smg.api.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.khmeracademy.smg.api.model.Staff;
import org.khmeracademy.smg.api.services.StaffService;
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
@RequestMapping("/api/staff")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	
	// insert student
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addStudent(@RequestBody Staff staff){
		Map<String, Object> map = new HashMap<>();
		try {
			if(staffService.insertSaff(staff)){
				map.put("MESSAGE", "Create new staff successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not create new staff!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	// get all student
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getStudent(){
		Map<String, Object> map = new HashMap<>();
		ArrayList<Staff> list=staffService.getStaff();
		try {
			if(!list.isEmpty()){
				map.put("DATA", list);
				map.put("MESSAGE", "Get staff successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not get staff!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	// get all student
	@RequestMapping(value="/{sta_id}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getStaffById(@PathVariable int sta_id){
		Map<String, Object> map = new HashMap<>();
		Staff listById=staffService.getStudentById(sta_id);
		try {
			if(listById!=null){
				map.put("DATA", listById);
				map.put("MESSAGE", "Get student by id: "+sta_id+" successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not get student by id!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	// update student
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> updateStaff(@RequestBody Staff staff){
		Map<String, Object> map = new HashMap<>();
		try {
			if(staffService.updateStaff(staff)){
				map.put("MESSAGE", "Update staff successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not update staff!");
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
