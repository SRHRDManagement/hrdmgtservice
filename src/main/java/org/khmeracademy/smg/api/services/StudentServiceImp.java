package org.khmeracademy.smg.api.services;

import java.util.ArrayList;

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

}
