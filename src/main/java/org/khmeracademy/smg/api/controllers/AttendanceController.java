package org.khmeracademy.smg.api.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.khmeracademy.smg.api.model.Attendance;
import org.khmeracademy.smg.api.services.AttendanceService;
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
@RequestMapping("/api/attendance")
public class AttendanceController {
	
	@Autowired
	private AttendanceService service;
	
	// insert attendance
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addAttendance(@RequestBody Attendance attendance){
		Map<String, Object> map = new HashMap<>();
		try {
			if(service.addAtt(attendance)){
				map.put("STATUS", true);
			}else{
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	// update attendance
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> updateAttendance(@RequestBody Attendance attendance){
		Map<String, Object> map = new HashMap<>();
		try {
			if(service.updateAttendanceExist(attendance)){
				map.put("MESSAGE", "Attendance was updated successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not update");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	// get check att exist
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> checkAttendanceExist(){
		Map<String, Object> map = new HashMap<>();
		ArrayList<Attendance> list=service.checkAttendanceExist();
		try {
			if(!list.isEmpty()){
				map.put("DATA", list);
				map.put("MESSAGE", "ww!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not");
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
