package org.khmeracademy.smg.api.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.smg.api.model.EnrollStaff;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollStaffRepository {
	
	String D_ES="delete from smg_studyprocess where sp_id=#{sp_id}";
	@Delete(D_ES)
	public boolean removeInstructor(int sp_id);
	
	String C_ES="insert into smg_studyprocess(cla_id, sub_id, sta_id, gen_id, cou_id)"
			+ " values(#{cla_id}, #{sub_id}, #{sta_id}, #{gen_id}, #{cou_id})";
	@Insert(C_ES)
	public boolean addEnrollStaff(EnrollStaff enrollStaff);
	
	String R_ES="SELECT sp.sp_id, st.sta_id, st.sta_lastname, st.sta_firstname, st.sta_avatar, sj.sub_name, ge.gen_name, cl.cla_name, co.cou_name"
		+" FROM smg_studyprocess sp INNER JOIN smg_staff st ON sp.sta_id = st.sta_id"
		+" INNER JOIN smg_class cl ON sp.cla_id = cl.cla_id"
		+" INNER JOIN smg_generation ge ON sp.gen_id = ge.gen_id"
		+" INNER JOIN smg_subject sj ON sp.sub_id = sj.sub_id"
		+" INNER JOIN smg_course co ON co.gen_id = ge.gen_id AND cl.cou_id = co.cou_id";
	@Select(R_ES)
	@Results(value={@Result(property="staff.sta_lastname", column="sta_lastname"),
			@Result(property="staff.sta_id", column="sta_id"),
			@Result(property="staff.sta_firstname", column="sta_firstname"),
			@Result(property="staff.sta_avatar", column="sta_avatar"),
			@Result(property="subject.sub_name", column="sub_name"),
			@Result(property="generation.gen_name", column="gen_name"),
			@Result(property="course.cou_name", column="cou_name"),
			@Result(property="clas.cla_name", column="cla_name")})
	public ArrayList<EnrollStaff> getInstructor();
	
	String R_ES_BY_GEN="SELECT sp.sp_id, st.sta_id, st.sta_lastname, st.sta_firstname, st.sta_avatar, sj.sub_name, ge.gen_name, cl.cla_name, co.cou_name"
			+" FROM smg_studyprocess sp INNER JOIN smg_staff st ON sp.sta_id = st.sta_id"
			+" INNER JOIN smg_class cl ON sp.cla_id = cl.cla_id"
			+" INNER JOIN smg_generation ge ON sp.gen_id = ge.gen_id"
			+" INNER JOIN smg_subject sj ON sp.sub_id = sj.sub_id"
			+" INNER JOIN smg_course co ON co.gen_id = ge.gen_id AND cl.cou_id = co.cou_id"
			+ " WHERE sp.gen_id=#{gen_id}";
		@Select(R_ES_BY_GEN)
		@Results(value={@Result(property="staff.sta_lastname", column="sta_lastname"),
				@Result(property="staff.sta_id", column="sta_id"),
				@Result(property="staff.sta_firstname", column="sta_firstname"),
				@Result(property="staff.sta_avatar", column="sta_avatar"),
				@Result(property="subject.sub_name", column="sub_name"),
				@Result(property="generation.gen_name", column="gen_name"),
				@Result(property="course.cou_name", column="cou_name"),
				@Result(property="clas.cla_name", column="cla_name")})
		public ArrayList<EnrollStaff> getInstructorByGeneration(EnrollStaff enrollStaff);

}
