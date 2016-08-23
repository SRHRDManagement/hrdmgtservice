package org.khmeracademy.smg.api.services;

import java.util.ArrayList;

import org.khmeracademy.smg.api.model.Month;
import org.khmeracademy.smg.api.model.Score;
import org.khmeracademy.smg.api.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImp implements ScoreService {
	
	@Autowired
	private ScoreRepository rep;

	@Override
	public ArrayList<Month> getAllMonths() {
		return rep.getAllMonths();
	}

	@Override
	public Month getMonthById(int mon_id) {
		return rep.getMonthById(mon_id);
	}

	@Override
	public ArrayList<Score> getScore(Score score) {
		return rep.getScore(score);
	}

	@Override
	public boolean insertScore(Score score) {
		return rep.insertScore(score);
	}

}
