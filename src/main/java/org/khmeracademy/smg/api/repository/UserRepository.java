package org.khmeracademy.smg.api.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.smg.api.model.Role;
import org.khmeracademy.smg.api.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
	@Select("SELECT usr_id, usr_email, usr_password, rol_id FROM smg_user WHERE usr_email=#{userEmail}")
	@Results(value = {
			@Result(property = "roles", column = "rol_id",
				many = @Many(select = "findRolesByRoleId")
			)
	})
	public User findUserByEmail(@Param("userEmail") String userEmail);

	@Select("SELECT rol_id, rol_title FROM smg_role WHERE rol_id=#{rol_id}")
	public ArrayList<Role> findRolesByRoleId( int rol_id);
	
	//get all users
	String R_USR="select usr_email, usr_firstname, usr_lastname, usr_date, rol_id, usr_gender, usr_phone, usr_avatar, usr_status from smg_user order by usr_id";
	@Select(R_USR)
	public ArrayList<User> getAllUsers();
	
	//insert user
	String C_USR="insert into smg_user(usr_email, usr_password, usr_firstname, usr_lastname, rol_id, usr_gender, usr_phone, usr_avatar, usr_status, sta_id, stu_id)"
			+ " values(#{usr_email}, #{usr_password}, #{usr_firstname}, #{usr_lastname}, #{rol_id}, #{usr_gender}, #{usr_phone}, #{usr_avatar}, #{usr_status}, #{sta_id}, #{stu_id})";
	@Insert(C_USR)
	public boolean addUser(User user);
}
