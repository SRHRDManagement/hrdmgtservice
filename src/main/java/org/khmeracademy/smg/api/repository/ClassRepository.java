package org.khmeracademy.smg.api.repository;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.smg.api.model.Class;
import org.khmeracademy.smg.api.model.Course;
import org.khmeracademy.smg.api.model.Generation;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository {
	
	//Insert class *
	String C_CLA="insert into smg_class(cla_name, cla_date, cou_id, cla_active)"
			+ "VALUES(#{cla_name}, #{cla_date}, #{cou_id}, #{cla_active})";
	@Insert(C_CLA)
	public boolean addClass(Class className);
	
	// get class by course ID *
	String R_CLA="select * from smg_class where cou_id=#{cou_id} order by cla_id";
	@Select(R_CLA)
	public ArrayList<Class> getClassByCourse(int cou_id);
	
	String R_BYID_COU="select * from smg_course where cou_id=#{cou_id}";
	@Select(R_BYID_COU)
	public Course getCourseById(int cou_id);
	
	String U_COU="update smg_course set cou_name=#{cou_name}, cou_start_date=#{cou_start_date}, cou_end_date=#{cou_end_date}"
			+ "where cou_id=#{cou_id}";
	@Update(U_COU)
	public boolean updateCourse(Course course);
	
	//disable generation
	String DISABLED_COU="UPDATE smg_course SET cou_is_finish=#{cou_is_finish} WHERE cou_id=#{cou_id}";
	@Update(DISABLED_COU)
	public boolean disabledCourse(Course course);
	
}
