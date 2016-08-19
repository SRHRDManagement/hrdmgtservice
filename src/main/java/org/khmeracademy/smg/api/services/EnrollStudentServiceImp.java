package org.khmeracademy.smg.api.services;

import org.khmeracademy.smg.api.model.EnrollStudent;
import org.khmeracademy.smg.api.repository.StudentEnrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollStudentServiceImp implements EnrollStudentService {

	@Autowired
	private StudentEnrollRepository rep;
	
	@Override
	public boolean addEnrollStudent(EnrollStudent enrolStudent) {
		return rep.addEnrollStudent(enrolStudent);
	}

	@Override
	public boolean unEnrollStudent(int stu_id) {
		return rep.unEnrollStudent(stu_id);
	}

}
