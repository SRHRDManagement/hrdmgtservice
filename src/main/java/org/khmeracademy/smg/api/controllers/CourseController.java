package org.khmeracademy.smg.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.smg.api.model.Course;
import org.khmeracademy.smg.api.services.CourseService;
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
	
}
