package org.khmeracademy.smg.api.services;

import java.util.ArrayList;
import org.khmeracademy.smg.api.model.Student;

public interface StudentService {
	public boolean insertStudent(Student student);
	public ArrayList<Student> getStudent();
}
