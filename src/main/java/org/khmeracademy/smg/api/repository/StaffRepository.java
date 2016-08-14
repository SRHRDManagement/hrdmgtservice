package org.khmeracademy.smg.api.repository;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.smg.api.model.Staff;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository {
	
	//create new student
	String C_STA="insert into smg_staff(sta_firstname, sta_lastname, sta_gender, sta_phone, sta_avatar, sta_status)"
			+ " values(#{sta_firstname}, #{sta_lastname}, #{sta_gender}, #{sta_phone}, #{sta_avatar}, #{sta_status})";
	@Insert(C_STA)
	public boolean insertStaff(Staff staff);
	
	//get all student information
	String R_STA="select * from smg_staff order by sta_id";
	@Select(R_STA)
	public ArrayList<Staff> getStaff();
	
	//get student by id
	String R_STA_BYID="select * from smg_staff where sta_id=#{sta_id}";
	@Select(R_STA_BYID)
	public Staff getStaffById(int sta_id);
	
	//update student by id
	String U_STA="update smg_staff set "
			+ "sta_firstname=#{sta_firstname},"
			+ "sta_lastname=#{sta_lastname},"
			+ "sta_gender=#{sta_gender},"
			+ "sta_phone=#{sta_phone},"
			+ "sta_avatar=#{sta_avatar}"
			+ "where sta_id=#{sta_id}";
	@Update(U_STA)
	public boolean updateStaff(Staff staff);

}
