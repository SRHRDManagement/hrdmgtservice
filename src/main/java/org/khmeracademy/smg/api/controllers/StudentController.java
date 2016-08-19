package org.khmeracademy.smg.api.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.khmeracademy.smg.api.model.Course;
import org.khmeracademy.smg.api.model.EnrollStudent;
import org.khmeracademy.smg.api.model.Student;
import org.khmeracademy.smg.api.repository.StudentRepository;
import org.khmeracademy.smg.api.model.Attendance;
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
	
	// get all student with attendance
	@RequestMapping(value="att/{cla_id}/{att_date_st}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getStudentAttendance(@PathVariable int cla_id, @PathVariable String att_date_st) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parse=format.parse(att_date_st);
		java.sql.Date date=new java.sql.Date(parse.getYear(), parse.getMonth(), parse.getDate());
		System.out.println(date);
		
		Student student = new Student();
		
		EnrollStudent enroll = new EnrollStudent();
		enroll.setCla_id(cla_id);
		student.setEnroll(enroll);
		
		Attendance attendance = new Attendance();
		attendance.setAtt_date(date);
		student.setAttendance(attendance);
		Map<String, Object> map = new HashMap<>();
		ArrayList<Student> list=studentService.getSudentAttendance(student);
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
	
	// get all not user
	@RequestMapping(value="student-not-user", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getStudentNotUser(){
		Map<String, Object> map = new HashMap<>();
		ArrayList<Student> list=studentService.getStudentNotUser();
		try {
			if(!list.isEmpty()){
				map.put("DATA", list);
				map.put("MESSAGE", "Get student not user successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not get student not user");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	// get all student not enroll
	@RequestMapping(value="not-enroll", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getStudentNotEnroll(){
		Map<String, Object> map = new HashMap<>();
		ArrayList<Student> list=studentService.getStudentNotEnroll();
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
	
	// get all student enroll
	@RequestMapping(value="/{gen_id}/{cla_id}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getStudentEnroll(@PathVariable int gen_id, @PathVariable int cla_id){
		Map<String, Object> map = new HashMap<>();
		EnrollStudent es = new EnrollStudent();
		Student s = new Student();
		s.setGen_id(gen_id);
		es.setStudent(s);
		
		Class c =new Class();
		c.setCla_id(cla_id);
		es.setClassx(c);
		
		ArrayList<EnrollStudent> list=studentService.getStudentEnroll(es);
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
	
	// get  student by id
	@RequestMapping(value="/{stu_id}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getStudentById(@PathVariable int stu_id){
		Map<String, Object> map = new HashMap<>();
		Student listById=studentService.getStudentById(stu_id);
		try {
			if(listById!=null){
				map.put("DATA", listById);
				map.put("MESSAGE", "Get student by id: "+stu_id+" successfully!");
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
	public ResponseEntity<Map<String, Object>> updateStudent(@RequestBody Student student){
		Map<String, Object> map = new HashMap<>();
		try {
			if(studentService.updateStudent(student)){
				map.put("MESSAGE", "Update student successfully!");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Can not update student!");
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
