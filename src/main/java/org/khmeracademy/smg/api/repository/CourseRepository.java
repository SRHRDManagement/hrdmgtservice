package org.khmeracademy.smg.api.repository;

import org.apache.ibatis.annotations.Insert;
import org.khmeracademy.smg.api.model.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository {
	String C_COU="insert into smg_course(cou_name, cou_start_date, cou_end_date, gen_id, cou_is_finish, cou_color)"
			+ "VALUES(#{cou_name}, #{cou_start_date}, #{cou_end_date}, #{gen_id}, #{cou_is_finish}, #{cou_color})";
	@Insert(C_COU)
	public boolean addCourse(Course course);
}
