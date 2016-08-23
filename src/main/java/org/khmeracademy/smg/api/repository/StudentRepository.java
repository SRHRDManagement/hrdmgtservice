package org.khmeracademy.smg.api.repository;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import org.khmeracademy.smg.api.model.EnrollStudent;
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
	
	//get all student Not enroll
	String R_STU_CH="select * from smg_student s where not exists(select 3 from smg_studentenroll e where s.stu_id=e.stu_id)";
	@Select(R_STU_CH)
	public ArrayList<Student> getStudentNotEnroll();
	
	//get all students that not register user
	String R_STU_NOT_USER="select * from smg_student s where not exists(select u.stu_id from smg_user u where s.stu_id=u.stu_id) order by stu_id";
	@Select(R_STU_NOT_USER)
	public ArrayList<Student> getStudentNotUser();
	
	//get all student enroll
	String R_STU_EN="select s.stu_id, s.stu_firstname, s.stu_lastname, s.stu_gender, s.stu_avatar from smg_studentenroll e inner join smg_student s"
			+ " on e.stu_id=s.stu_id where e.cla_id=#{classx.cla_id} and s.gen_id=#{student.gen_id}";
	@Select(R_STU_EN)
	@Results(value={@Result(property="student.gen_id", column="gen_id"),
			@Result(property="student.stu_id", column="stu_id"),
			@Result(property="student.stu_gender", column="stu_gender"),
			@Result(property="student.stu_avatar", column="stu_avatar"),
			@Result(property="student.stu_firstname", column="stu_firstname"),
			@Result(property="student.stu_lastname", column="stu_lastname")})
	public ArrayList<EnrollStudent> getStudentEnroll(EnrollStudent enroll);
	
	@Select("select * from smg_studentenroll where cla_id=#{cla_id}")
	public ArrayList<EnrollStudent> connectionStudent(int cla_id);
	
	String R_STU_ATT="SELECT s.*, at.* FROM smg_student s"
+" JOIN smg_studentenroll se ON se.stu_id = s.stu_id"
+" LEFT JOIN smg_attendance at on at.stu_id=s.stu_id AND at.att_date = #{attendance.att_date} AND at.att_shift = #{attendance.att_shift}"
+" WHERE se.cla_id = #{enroll.cla_id}";
	@Select(R_STU_ATT)
	@Results(value={
			@Result(property="enroll.stu_id", column="stu_id"),
			@Result(property="attendance.stu_id", column="stu_id"),
			@Result(property="attendance.att_reason", column="att_reason"),
			@Result(property="attendance.abs_id", column="abs_id"),
			@Result(property="enroll.cla_id", column="cla_id"),
			@Result(property="attendance.att_shift", column="att_shift"),
			@Result(property="attendance.att_date", column="att_date")
	})
	public ArrayList<Student> getSudentAttendance(Student student);
	
	//get student by id
	String R_STU_BYID="select * from smg_student where stu_id=#{stu_id}";
	@Select(R_STU_BYID)
	public Student getStudentById(int stu_id);
	
	//update student by id
	String U_STU="update smg_student set "
			+ "stu_firstname=#{stu_firstname},"
			+ "stu_lastname=#{stu_lastname},"
			+ "stu_gender=#{stu_gender},"
			+ "stu_dob=#{stu_dob},"
			+ "stu_address=#{stu_address},"
			+ "stu_phone=#{stu_phone},"
			+ "stu_nationality=#{stu_nationality},"
			+ "stu_social_id=#{stu_social_id},"
			+ "stu_avatar=#{stu_avatar},"
			+ "stu_fathername=#{stu_fathername},"
			+ "stu_father_phone=#{stu_father_phone},"
			+ "stu_father_job=#{stu_father_job},"
			+ "stu_mothername=#{stu_mothername},"
			+ "stu_mother_phone=#{stu_mother_phone},"
			+ "stu_mother_job=#{stu_mother_job} "
			+ "where stu_id=#{stu_id}";
	@Update(U_STU)
	public boolean updateStudent(Student student);

}
