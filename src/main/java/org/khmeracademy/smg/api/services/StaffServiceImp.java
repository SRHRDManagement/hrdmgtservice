package org.khmeracademy.smg.api.services;

import java.util.ArrayList;

import org.khmeracademy.smg.api.model.Staff;
import org.khmeracademy.smg.api.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImp implements StaffService {
	
	@Autowired
	private StaffRepository staffRep;

	@Override
	public boolean insertSaff(Staff staff) {
		return staffRep.insertStaff(staff);
	}

	@Override
	public ArrayList<Staff> getStaff() {
		return staffRep.getStaff();
	}

	@Override
	public Staff getStudentById(int sta_id) {
		return staffRep.getStaffById(sta_id);
	}

	@Override
	public boolean updateStaff(Staff staff) {
		return staffRep.updateStaff(staff);
	}

}
