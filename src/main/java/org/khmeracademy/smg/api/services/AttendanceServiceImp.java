package org.khmeracademy.smg.api.services;

import java.sql.Date;
import java.util.ArrayList;

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

	@Override
	public boolean updateAttendanceExist(Attendance att) {
		return rep.updateAttendanceExist(att);
	}

	@Override
	public ArrayList<Attendance> checkAttendanceExist() {
		return rep.checkAttendanceExist();
	}

}
