package org.khmeracademy.smg.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.smg.api.model.Attendance;
import org.khmeracademy.smg.api.model.Class;
import org.khmeracademy.smg.api.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/attendance")
public class AttendanceController {
	
	@Autowired
	private AttendanceService service;
	
	// insert attendance
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addClass(@RequestBody Attendance attendance){
		Map<String, Object> map = new HashMap<>();
		try {
			if(service.addAtt(attendance)){
				map.put("MESSAGE", "Attendance was insertd successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not insert");
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
