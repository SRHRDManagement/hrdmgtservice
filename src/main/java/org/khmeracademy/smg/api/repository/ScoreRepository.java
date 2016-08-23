package org.khmeracademy.smg.api.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.smg.api.model.Month;
import org.khmeracademy.smg.api.model.Score;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository {
	
	String R_MON="select * from smg_month";
	@Select(R_MON)
	public ArrayList<Month> getAllMonths();
	
	String R_MON_BYID="select * from smg_month where mon_id=#{mon_id}";
	@Select(R_MON_BYID)
	public Month getMonthById(int mon_id);
	
	String R_SCO="SELECT st.stu_id, st.stu_firstname, st.stu_lastname, st.stu_avatar, st.stu_gender, st.stu_dob, sc.sco_score, sc.mon_id, se.cla_id "
			+ "FROM smg_score sc "
			+ "RIGHT JOIN smg_studentenroll se ON sc.stu_id=se.stu_id AND sc.mon_id=#{mon_id} AND sc.sub_id=#{sub_id} "
			+ "INNER JOIN smg_student st ON se.stu_id=st.stu_id "
			+ "WHERE se.cla_id=#{enrollStudent.cla_id}";
	@Select(R_SCO)
	@Results(value={@Result(property="student.gen_id", column="gen_id"),
			@Result(property="enrollStudent.cla_id", column="cla_id"),
			@Result(property="student.stu_id", column="stu_id"),
			@Result(property="student.stu_dob", column="stu_dob"),
			@Result(property="enrollStudent.stu_id", column="stu_id"),
			@Result(property="student.stu_gender", column="stu_gender"),
			@Result(property="student.stu_avatar", column="stu_avatar"),
			@Result(property="student.stu_firstname", column="stu_firstname"),
			@Result(property="student.stu_lastname", column="stu_lastname")})
	public ArrayList<Score> getScore(Score score);
	
	String C_SCO="UPDATE smg_score SET sco_score=#{sco_score} WHERE stu_id=#{stu_id} AND sub_id=#{sub_id} AND mon_id=#{mon_id}; "
			+ "INSERT INTO smg_score(sco_score, stu_id, sub_id, mon_id) "
			+ "SELECT #{sco_score}, #{stu_id}, #{sub_id}, #{mon_id} WHERE NOT EXISTS(SELECT 1 FROM smg_score WHERE stu_id=#{stu_id} AND sub_id=#{sub_id} AND mon_id=#{mon_id})";
	@Update(C_SCO)
	public boolean insertScore(Score score);

}
