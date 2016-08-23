package org.khmeracademy.smg.api.services;

import java.util.ArrayList;

import org.khmeracademy.smg.api.model.EnrollStaff;
import org.khmeracademy.smg.api.repository.EnrollStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollStaffServiceImp implements EnrollStaffService {
	
	@Autowired
	private EnrollStaffRepository rep;

	@Override
	public boolean addEnrollStaff(EnrollStaff enrollStaff) {
		return rep.addEnrollStaff(enrollStaff);
	}

	@Override
	public ArrayList<EnrollStaff> getInstructor() {
		return rep.getInstructor();
	}

	@Override
	public boolean removeInstructor(int sp_id) {
		return rep.removeInstructor(sp_id);
	}

	@Override
	public ArrayList<EnrollStaff> getInstructorByGeneration(EnrollStaff enrollStaff) {
		return rep.getInstructorByGeneration(enrollStaff);
	}

}
