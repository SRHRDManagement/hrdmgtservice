package org.khmeracademy.smg.api.repository;

import org.apache.ibatis.annotations.Insert;
import org.khmeracademy.smg.api.model.Attendance;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository {
	
	//Insert attendance *
	String C_ATT="insert into smg_attendance(att_date, att_shift, stu_id, att_reason, abs_id)"
			+ "VALUES(#{att_date}, #{att_shift}, #{stu_id}, #{att_reason}, #{abs_id})";
	@Insert(C_ATT)
	public boolean addAtt(Attendance attendance);
	
}
