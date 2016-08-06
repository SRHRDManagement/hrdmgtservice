package org.khmeracademy.smg.api.repository;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.smg.api.model.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository {
	String C_COU="insert into smg_course(cou_name, cou_start_date, cou_end_date, gen_id, cou_is_finish)"
			+ "VALUES(#{cou_name}, #{cou_start_date}, #{cou_end_date}, #{gen_id}, #{cou_is_finish})";
	@Insert(C_COU)
	public boolean addCourse(Course course);
	
	String R_COU="select * from smg_course where gen_id=#{gen_id}";
	@Select(R_COU)
	public ArrayList<Course> getCourseByGeneration(int gen_id);
}
