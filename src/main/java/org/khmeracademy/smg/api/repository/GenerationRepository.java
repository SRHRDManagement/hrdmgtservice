package org.khmeracademy.smg.api.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.smg.api.model.Generation;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerationRepository {
	
	//insert generation
	String C_GEN="INSERT INTO smg_generation(gen_name,  gen_start_date, gen_end_date, gen_is_finish)"
			+ "VALUES(#{gen_name}, #{gen_start_date}, #{gen_end_date}, #{gen_is_finish})";
	@Insert(C_GEN)
	public boolean addGeneration(Generation generation);
	
	//get generation
	String R_GEN="SELECT * FROM smg_generation ORDER BY gen_id";
	@Select(R_GEN)
	public ArrayList<Generation> getGeneration();
	
	//update generation
	String U_GEN="UPDATE smg_generation SET gen_name=#{gen_name}, gen_start_date=#{gen_start_date}, gen_end_date=#{gen_end_date} WHERE gen_id=#{gen_id}";
	@Update(U_GEN)
	public boolean updateGeneration(Generation generation);
	
	//getGenerationById
	String GETBYID="SELECT * FROM smg_generation WHERE gen_id=#{gen_id}";
	@Select(GETBYID)
	public Generation getGenerationById(int gen_id);
	
	//disable generation
	String DISABLED_GEN="UPDATE smg_generation SET gen_is_finish=#{gen_is_finish} WHERE gen_id=#{gen_id}";
	@Update(DISABLED_GEN)
	public boolean disabledGeneration(Generation generation);
	
	//find generation that not finish
	String GOON_GEN="select * from smg_generation where gen_is_finish=#{gen_is_finish}";
	@Select(GOON_GEN)
	public Generation generationNotFinish(boolean gen_is_finish);
	
}
