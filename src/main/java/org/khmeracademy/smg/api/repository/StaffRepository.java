package org.khmeracademy.smg.api.repository;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.smg.api.model.EnrollStaff;
import org.khmeracademy.smg.api.model.Staff;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository {
	
	//create new student
	String C_STA="insert into smg_staff(sta_firstname, sta_lastname, sta_gender, sta_phone, sta_avatar, sta_status)"
			+ " values(#{sta_firstname}, #{sta_lastname}, #{sta_gender}, #{sta_phone}, #{sta_avatar}, #{sta_status})";
	@Insert(C_STA)
	public boolean insertStaff(Staff staff);
	
	//get all staff information
	String R_STA="select * from smg_staff order by sta_id";
	@Select(R_STA)
	public ArrayList<Staff> getStaff();
	
	//get all staff information not-in-study-process
	String R_STA_NOT_PRO="select s.sta_id, s.sta_firstname, s.sta_lastname from  smg_staff s"
			+ " where s.sta_id  not in (select sp.sta_id from smg_studyprocess sp"
			+ " inner join smg_class cl on cl.cla_id=sp.cla_id"
			+ " inner join smg_subject su on su.sub_id=sp.sub_id where cl.cla_id=#{clas.cla_id} and su.sub_id=#{subject.sub_id}) order by s.sta_id";
	@Select(R_STA_NOT_PRO)
	@Results(value={@Result(property="studyProcess.sta_id", column="sta_id"),
			@Result(property="clas.cla_id", column="cla_id"),
			@Result(property="subject.sub_id", column="sub_id")})
	public ArrayList<Staff> getStaffNotProcess(EnrollStaff enrollStaff);
	
	//get all staff that not register user
	String R_STA_NOT_USER="select * from smg_staff s where not exists(select u.sta_id from smg_user u where s.sta_id=u.sta_id) order by sta_id";
	@Select(R_STA_NOT_USER)
	public ArrayList<Staff> getStaffNotUser();
	
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
