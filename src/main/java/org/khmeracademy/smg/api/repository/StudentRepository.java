package org.khmeracademy.smg.api.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.smg.api.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository {
	
	//create new student
	String C_STU="insert into smg_student(stu_firstname, stu_lastname, stu_gender, stu_dob, stu_address, stu_phone, stu_nationality, stu_social_id, stu_avatar, stu_fathername, stu_father_phone, stu_father_job, stu_mothername, stu_mother_phone, stu_mother_job, stu_status, gen_id)"
			+ " values(#{stu_firstname}, #{stu_lastname}, #{stu_gender}, #{stu_dob}, #{stu_address}, #{stu_phone}, #{stu_nationality}, #{stu_social_id}, #{stu_avatar}, #{stu_fathername}, #{stu_father_phone}, #{stu_father_job}, #{stu_mothername}, #{stu_mother_phone}, #{stu_mother_job}, #{stu_status}, #{gen_id})";
	@Insert(C_STU)
	public boolean insertStudent(Student student);
	
	//get all student information
	String R_STU="select * from smg_student order by stu_id";
	@Select(R_STU)
	public ArrayList<Student> getStudent();

}
