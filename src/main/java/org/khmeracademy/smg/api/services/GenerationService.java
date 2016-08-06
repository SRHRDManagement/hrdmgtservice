package org.khmeracademy.smg.api.services;

import java.util.ArrayList;

import org.khmeracademy.smg.api.model.Generation;

public interface GenerationService {
	public boolean addGeneration(Generation generation);
	public ArrayList<Generation> getGeneration();
	public boolean updateGeneration(Generation generation);
	public Generation getGenerationById(int gen_id);
	public boolean disabledGeneration(Generation generation);
	public Generation generationNotFinish(boolean gen_is_finish);
}
