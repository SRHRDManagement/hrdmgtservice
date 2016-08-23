package org.khmeracademy.smg.api.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.khmeracademy.smg.api.model.Course;
import org.khmeracademy.smg.api.model.EnrollStudent;
import org.khmeracademy.smg.api.model.Month;
import org.khmeracademy.smg.api.model.Score;
import org.khmeracademy.smg.api.model.Class;
import org.khmeracademy.smg.api.services.ClassService;
import org.khmeracademy.smg.api.services.CourseService;
import org.khmeracademy.smg.api.services.ScoreService;
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
@RequestMapping("/api/score")
public class ScoreController {
	
	@Autowired
	private ScoreService service;
	
	// insert score
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> insertScore(@RequestBody Score score){
		Map<String, Object> map = new HashMap<>();
		try {
			if(service.insertScore(score)){
				map.put("MESSAGE", "Data insert successfully");
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
	
	// get all months
	@RequestMapping(value="month", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getAllMonth(){
		Map<String, Object> map = new HashMap<>();
		ArrayList<Month> list = service.getAllMonths();
		try {
			if(!list.isEmpty()){
				map.put("DATA", list);
				map.put("MESSAGE", "Data found");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Not found");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	// get month by id
	@RequestMapping(value="month/{mon_id}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getMonthById(@PathVariable int mon_id){
		Map<String, Object> map = new HashMap<>();
		Month month = service.getMonthById(mon_id);
		try {
			if(month!=null){
				map.put("DATA", month);
				map.put("MESSAGE", "Data found");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Not found");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	// get score
	@RequestMapping(value="/{mon_id}/{cla_id}/{sub_id}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getScore(@PathVariable int mon_id, @PathVariable int cla_id, @PathVariable int sub_id){
		Map<String, Object> map = new HashMap<>();
		Score score = new Score();
		EnrollStudent enrollStudent=new EnrollStudent();
		enrollStudent.setCla_id(cla_id);
		score.setEnrollStudent(enrollStudent);
		score.setMon_id(mon_id);
		score.setSub_id(sub_id);
		ArrayList<Score> list = service.getScore(score);
		try {
			if(!list.isEmpty()){
				map.put("DATA", list);
				map.put("MESSAGE", "Data found");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Not found");
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
