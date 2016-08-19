package org.khmeracademy.smg.api.services;

import java.sql.Date;
import java.util.ArrayList;

import org.khmeracademy.smg.api.model.Attendance;
import org.khmeracademy.smg.api.model.EnrollStudent;
import org.khmeracademy.smg.api.model.Student;

public interface StudentService {
	public boolean insertStudent(Student student);
	public ArrayList<Student> getStudent();
	public Student getStudentById(int stu_id);
	public boolean updateStudent(Student student);
	public ArrayList<Student> getStudentNotEnroll();
	public ArrayList<EnrollStudent> getStudentEnroll(EnrollStudent enroll);
	public ArrayList<EnrollStudent> connectionStudent(int cla_id);
	public ArrayList<Student> getStudentNotUser();
	public ArrayList<Student> getSudentAttendance(Student student);
}
