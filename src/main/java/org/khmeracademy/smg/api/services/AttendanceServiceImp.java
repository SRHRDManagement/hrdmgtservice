package org.khmeracademy.smg.api.services;

import org.khmeracademy.smg.api.model.Attendance;
import org.khmeracademy.smg.api.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImp implements AttendanceService {

	@Autowired
	private AttendanceRepository rep;
	
	@Override
	public boolean addAtt(Attendance attendance) {
		return rep.addAtt(attendance);
	}

}
