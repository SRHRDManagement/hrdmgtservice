package org.khmeracademy.smg.api.repository;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.smg.api.model.Attendance;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository {
	
	//Insert attendance *
	String C_ATT="insert into smg_attendance(att_date, att_shift, stu_id, att_reason, abs_id)"
			+ "VALUES(#{att_date}, #{att_shift}, #{stu_id}, #{att_reason}, #{abs_id})";
	@Insert(C_ATT)
	public boolean addAtt(Attendance attendance);
	
	//String check attendance exist
	String R_ATT_EXIST="select att_date, att_shift, stu_id from smg_attendance order by att_id";
	@Select(R_ATT_EXIST)
	public ArrayList<Attendance> checkAttendanceExist();
	
	//update attendance
	String U_ATT_EXIST="UPDATE smg_attendance SET att_reason=#{att_reason}, abs_id=#{abs_id} WHERE att_date=#{att_date} AND att_shift=#{att_shift} AND stu_id=#{stu_id};"
			+ " INSERT INTO smg_attendance(att_date, att_shift, stu_id, att_reason, abs_id)"
			+ " SELECT #{att_date}, #{att_shift}, #{stu_id}, #{att_reason}, #{abs_id} WHERE NOT EXISTS (SELECT 1 FROM smg_attendance WHERE att_date=#{att_date} AND att_shift=#{att_shift} AND stu_id=#{stu_id});"
			+ " DELETE FROM smg_attendance WHERE abs_id=4";
	@Update(U_ATT_EXIST)
	public boolean updateAttendanceExist(Attendance att);
	
}
