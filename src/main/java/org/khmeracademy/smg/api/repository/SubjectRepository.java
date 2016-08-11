package org.khmeracademy.smg.api.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.smg.api.model.Subject;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository {
	
	// get subject  *
	String R_SUB="select * from smg_subject order by sub_id";
	@Select(R_SUB)
	public ArrayList<Subject> getSubject();
	
	// get subject by course ID *
	String R_SUB_BYID="select * from smg_subject where sub_id=#{sub_id} order by sub_id";
	@Select(R_SUB_BYID)
	public Subject getSubjectById(int sub_id);
	
	//create new subject *
	String C_SUB="insert into smg_subject(sub_name, sub_date, sub_description, sub_active)"
			+ "values(#{sub_name}, #{sub_date}, #{sub_description}, #{sub_active})";
	@Insert(C_SUB)
	public boolean insertSubject(Subject subject);
	
	//update subject *
	String U_SUB="update smg_subject set sub_name=#{sub_name}, sub_date=#{sub_date}, sub_description=#{sub_description}"
			+ "where sub_id=#{sub_id}";
	@Update(U_SUB)
	public boolean updateSubject(Subject subject);
	
	//delete or disable subject *
	String D_SUB="update smg_subject set sub_active=#{sub_active} where sub_id=#{sub_id}";
	@Update(D_SUB)
	public boolean deleteDisableSubject(Subject subject);
}
