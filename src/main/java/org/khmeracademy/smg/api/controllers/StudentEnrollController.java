package org.khmeracademy.smg.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.smg.api.model.EnrollStudent;
import org.khmeracademy.smg.api.services.EnrollStudentService;
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
@RequestMapping("/api/student-enroll")
public class StudentEnrollController {
	
	@Autowired
	private EnrollStudentService service;
	
	// enroll student to class
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> enrollStudent(@RequestBody EnrollStudent enrollStudent){
		Map<String, Object> map = new HashMap<>();
		try {
			if(service.addEnrollStudent(enrollStudent)){
				map.put("MESSAGE", "Enroll student successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not enroll student successfully!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	// unenroll student from class
	@RequestMapping(value="/{stu_id}", method=RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> unEnrollStudent(@PathVariable int stu_id){
		Map<String, Object> map = new HashMap<>();
		try {
			if(service.unEnrollStudent(stu_id)){
				map.put("MESSAGE", "Enroll student successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not enroll student successfully!");
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
