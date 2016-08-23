package org.khmeracademy.smg.api.services;

import java.util.ArrayList;

import org.khmeracademy.smg.api.model.EnrollStaff;

public interface EnrollStaffService {
	public boolean addEnrollStaff(EnrollStaff enrollStaff);
	public ArrayList<EnrollStaff> getInstructor();
	public boolean removeInstructor(int sp_id);
	public ArrayList<EnrollStaff> getInstructorByGeneration(EnrollStaff enrollStaff);
}
