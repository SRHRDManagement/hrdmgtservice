package org.khmeracademy.smg.api.services;

import java.util.ArrayList;
import org.khmeracademy.smg.api.model.EnrollStudent;
import org.khmeracademy.smg.api.model.Student;
import org.khmeracademy.smg.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public boolean insertStudent(Student student) {
		return studentRepository.insertStudent(student);
	}

	@Override
	public ArrayList<Student> getStudent() {
		return studentRepository.getStudent();
	}

	@Override
	public Student getStudentById(int stu_id) {
		return studentRepository.getStudentById(stu_id);
	}

	@Override
	public boolean updateStudent(Student student) {
		return studentRepository.updateStudent(student);
	}

	@Override
	public ArrayList<Student> getStudentNotEnroll() {
		return studentRepository.getStudentNotEnroll();
	}

	@Override
	public ArrayList<EnrollStudent> getStudentEnroll(EnrollStudent enroll) {
		return studentRepository.getStudentEnroll(enroll);
	}

	@Override
	public ArrayList<EnrollStudent> connectionStudent(int cla_id) {
		return studentRepository.connectionStudent(cla_id);
	}

	@Override
	public ArrayList<Student> getStudentNotUser() {
		return studentRepository.getStudentNotUser();
	}

	@Override
	public ArrayList<Student> getSudentAttendance(Student student) {
		return studentRepository.getSudentAttendance(student);
	}	

}
