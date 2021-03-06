package org.khmeracademy.smg.api.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.smg.api.model.Course;
import org.khmeracademy.smg.api.model.Generation;
import org.khmeracademy.smg.api.services.CourseService;
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
@RequestMapping("/api/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addCourse(@RequestBody Course course){
		Map<String, Object> map = new HashMap<>();
		try {
			if(courseService.addCourse(course)){
				map.put("MESSAGE", "Create new course successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not create new course successfully!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{gen_id}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getCourseByGenerationId(@PathVariable int gen_id){
		Map<String, Object> map = new HashMap<>();
		ArrayList<Course> courseList = courseService.getCourseByGeneration(gen_id);
		try {
			if(!courseList.isEmpty()){
				map.put("DATA", courseList);
				map.put("MESSAGE", "Get course by generation id successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "can not get course by generation id!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="get-course-by-id/{cou_id}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getCourseById(@PathVariable int cou_id){
		Map<String, Object> map = new HashMap<>();
		Course courseById = courseService.getCourseById(cou_id);
		try {
			if(courseById!=null){
				map.put("DATA", courseById);
				map.put("MESSAGE", "Get course by id successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "can not get course by id!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> updateCourse(@RequestBody Course course){
		Map<String, Object> map = new HashMap<>();
		try {
			if(courseService.updateCourse(course)){
				map.put("MESSAGE", "Update course successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not update course!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> disabledGeneration(@RequestBody Course course){
		Map<String, Object> map=new HashMap<>();
		try {
			if(courseService.disabledCourse(course)){
				map.put("MESSAGE", "disable course successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "disable course Unsuccessfully!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="course-not-finish", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> generationNotFinish(){
		boolean gen_is_finish=false;
		Map<String, Object> map=new HashMap<>();
		Course course = courseService.courseNotFinish(gen_is_finish);
		try {
			if(course!=null){
				map.put("DATA", course);
				map.put("MESSAGE", "Data found course is still go on successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Data not found Unsuccessfully!");
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
