package org.khmeracademy.smg.api.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.smg.api.model.Course;
import org.khmeracademy.smg.api.model.Subject;
import org.khmeracademy.smg.api.model.Class;
import org.khmeracademy.smg.api.services.ClassService;
import org.khmeracademy.smg.api.services.CourseService;
import org.khmeracademy.smg.api.services.SubjectService;
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
@RequestMapping("/api/subject")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	// get subject *
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getSubject(){
		Map<String, Object> map = new HashMap<>();
		ArrayList<Subject> subjectList = subjectService.getSubject();
		try {
			if(!subjectList.isEmpty()){
				map.put("DATA", subjectList);
				map.put("MESSAGE", "Get subjects successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "can not get subject!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	// get subject by id *
	@RequestMapping(value="/{sub_id}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getSubjectById(@PathVariable int sub_id){
		Map<String, Object> map = new HashMap<>();
		Subject subject = subjectService.getSubjectById(sub_id);
		try {
			if(subject!=null){
				map.put("DATA", subject);
				map.put("MESSAGE", "Get subjects successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "can not get subject!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	// insert subject *
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> insertSubject(@RequestBody Subject subject){
		Map<String, Object> map = new HashMap<>();
		try {
			if(subjectService.insertSubject(subject)){
				map.put("MESSAGE", "Insert subjects successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "can not insert subject!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	// update subject *
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> updateSubject(@RequestBody Subject subject){
		Map<String, Object> map = new HashMap<>();
		try {
			if(subjectService.updateSubject(subject)){
				map.put("MESSAGE", "Update subjects successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "can not update subject!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	// delete subject *
	@RequestMapping(value="delete", method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> deleteDisableSubject(@RequestBody Subject subject){
		Map<String, Object> map = new HashMap<>();
		try {
			if(subjectService.deleteDisableSubject(subject)){
				map.put("MESSAGE", "Update subjects successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "can not update subject!");
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
