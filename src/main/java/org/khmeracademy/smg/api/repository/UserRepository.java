package org.khmeracademy.smg.api.repository;

import java.util.ArrayList;
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
}
