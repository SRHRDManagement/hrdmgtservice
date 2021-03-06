package org.khmeracademy.smg.api.services;

import java.util.ArrayList;

import org.khmeracademy.smg.api.model.EnrollStaff;
import org.khmeracademy.smg.api.model.Staff;

public interface StaffService {
	public boolean insertSaff(Staff staff);
	public ArrayList<Staff> getStaff();
	public Staff getStudentById(int sta_id);
	public boolean updateStaff(Staff staff);
	public ArrayList<Staff> getStaffNotUser();
	public ArrayList<Staff> getStaffNotProcess(EnrollStaff enrollStaff);
}
