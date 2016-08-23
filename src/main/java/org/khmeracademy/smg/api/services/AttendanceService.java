package org.khmeracademy.smg.api.services;

import java.sql.Date;
import java.util.ArrayList;

import org.khmeracademy.smg.api.model.Attendance;

public interface AttendanceService {
	public boolean addAtt(Attendance attendance);
	public ArrayList<Attendance> checkAttendanceExist();
	public boolean updateAttendanceExist(Attendance attendance);
}
