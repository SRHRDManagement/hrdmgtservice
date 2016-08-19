package org.khmeracademy.smg.api.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.smg.api.model.Course;
import org.khmeracademy.smg.api.model.Class;
import org.khmeracademy.smg.api.services.ClassService;
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
@RequestMapping("/api/class")
public class ClassController {
	
	@Autowired
	private ClassService classService;
	
	// insert class in each course *
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addClass(@RequestBody Class className){
		Map<String, Object> map = new HashMap<>();
		try {
			if(classService.addClass(className)){
				map.put("MESSAGE", "Create new classroom successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not create new classroom successfully!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	// get class in each course *
	@RequestMapping(value="/{cou_id}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getClassByCourseId(@PathVariable int cou_id){
		Map<String, Object> map = new HashMap<>();
		ArrayList<Class> classList = classService.getClassByCourse(cou_id);
		try {
			if(!classList.isEmpty()){
				map.put("DATA", classList);
				map.put("MESSAGE", "Get class by course id successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "can not get class by course id!");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	// get class by id *
		@RequestMapping(value="get-class-by-id/{cla_id}", method=RequestMethod.GET)
		public ResponseEntity<Map<String, Object>> getClassById(@PathVariable int cla_id){
			Map<String, Object> map = new HashMap<>();
			Class clas = classService.getClassById(cla_id);
			try {
				if(clas!=null){
					map.put("DATA", clas);
					map.put("MESSAGE", "Get class by id successfully!");
					map.put("STATUS", true);
				}else{
					map.put("MESSAGE", "can not get class by id!");
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
	public ResponseEntity<Map<String, Object>> updateClass(@RequestBody Class clas){
		Map<String, Object> map = new HashMap<>();
		try {
			if(classService.updateClass(clas)){
				map.put("MESSAGE", "Update class successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not update class!");
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
	public ResponseEntity<Map<String, Object>> disabledClass(@RequestBody Class clas){
		Map<String, Object> map=new HashMap<>();
		try {
			if(classService.disabledCourse(clas)){
				map.put("MESSAGE", "disable class successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "disable class Unsuccessfully!");
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
