package org.khmeracademy.smg.api.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.smg.api.model.Course;
import org.khmeracademy.smg.api.model.Student;
import org.khmeracademy.smg.api.repository.StudentRepository;
import org.khmeracademy.smg.api.model.Class;
import org.khmeracademy.smg.api.services.ClassService;
import org.khmeracademy.smg.api.services.CourseService;
import org.khmeracademy.smg.api.services.StudentService;
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
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	// insert student
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addStudent(@RequestBody Student student){
		Map<String, Object> map = new HashMap<>();
		try {
			if(studentService.insertStudent(student)){
				map.put("MESSAGE", "Create new student successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not create new student!");
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
			ArrayList<Student> list=studentService.getStudent();
			try {
				if(!list.isEmpty()){
					map.put("DATA", list);
					map.put("MESSAGE", "Get student successfully!");
					map.put("STATUS", true);
				}else{
					map.put("MESSAGE", "Can not get student!");
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
