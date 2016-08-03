package org.khmeracademy.smg.services;

import java.util.ArrayList;

import org.khmeracademy.smg.model.Generation;
import org.khmeracademy.smg.repository.GenerationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenerationServiceImp implements GenerationService {
	
	@Autowired
	private GenerationRepository generationRepository;

	@Override
	public boolean addGeneration(Generation generation) {
		return generationRepository.addGeneration(generation);
	}

	@Override
	public ArrayList<Generation> getGeneration() {
		return generationRepository.getGeneration();
	}

	@Override
	public boolean updateGeneration(Generation generation) {
		return generationRepository.updateGeneration(generation);
	}

	@Override
	public Generation getGenerationById(int gen_id) {
		return generationRepository.getGenerationById(gen_id);
	}

	@Override
	public boolean disabledGeneration(Generation generation) {
		return generationRepository.disabledGeneration(generation);
	}

}
