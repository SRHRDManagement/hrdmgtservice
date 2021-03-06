package org.khmeracademy.smg.api.repository;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.smg.api.model.Course;
import org.khmeracademy.smg.api.model.Generation;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository {
	String C_COU="insert into smg_course(cou_name, cou_start_date, cou_end_date, gen_id, cou_is_finish)"
			+ "VALUES(#{cou_name}, #{cou_start_date}, #{cou_end_date}, #{gen_id}, #{cou_is_finish})";
	@Insert(C_COU)
	public boolean addCourse(Course course);
	
	String R_COU="select * from smg_course where gen_id=#{gen_id} order by cou_id";
	@Select(R_COU)
	public ArrayList<Course> getCourseByGeneration(int gen_id);
	
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
	
	//find course that not finish
	String GOON_COU="select * from smg_course where cou_is_finish=#{cou_is_finish}";
	@Select(GOON_COU)
	public Course courseNotFinish(boolean cou_is_finish);
	
}
