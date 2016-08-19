package org.khmeracademy.smg.api.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.khmeracademy.smg.api.model.EnrollStudent;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEnrollRepository {
	
	//enroll student *
	String C_STUEN="insert into smg_studentenroll(cla_id, stu_id)"
			+ "VALUES(#{cla_id}, #{stu_id})";
	@Insert(C_STUEN)
	public boolean addEnrollStudent(EnrollStudent enrolStudent);
	
	//unEnroll student
	String D_STUEN="delete from smg_studentenroll where stu_id=#{stu_id}";
	@Delete(D_STUEN)
	public boolean unEnrollStudent(int stu_id);
	
}
