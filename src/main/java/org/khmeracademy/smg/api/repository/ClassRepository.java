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
	
	// get class by class id *
	String R_CLA_BYID="select * from smg_class where cla_id=#{cla_id}";
	@Select(R_CLA_BYID)
	public Class getClassById(int cla_id);
	
	// update class *
	String U_CLA="update smg_class set cla_name=#{cla_name}, cla_date=#{cla_date}"
			+ "where cla_id=#{cla_id}";
	@Update(U_CLA)
	public boolean updateClass(Class clas);
	
	//disable class *
	String DISABLED_CLA="update smg_class SET cla_active=#{cla_active} WHERE cla_id=#{cla_id}";
	@Update(DISABLED_CLA)
	public boolean disabledCourse(Class cla);
	
}
