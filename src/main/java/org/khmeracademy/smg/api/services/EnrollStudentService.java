package org.khmeracademy.smg.api.services;

import org.khmeracademy.smg.api.model.EnrollStudent;

public interface EnrollStudentService {
	public boolean addEnrollStudent(EnrollStudent enrolStudent);
	public boolean unEnrollStudent(int stu_id);
}
