package org.khmeracademy.smg.api.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.khmeracademy.smg.api.model.Month;
import org.khmeracademy.smg.api.model.Score;
import org.khmeracademy.smg.api.model.Subject;
import org.khmeracademy.smg.api.repository.ScoreRepository;
import org.khmeracademy.smg.api.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImp implements ScoreService {
	
	@Autowired
	private ScoreRepository rep;
	
	@Autowired
	private SubjectRepository subjectRepository;

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

	@Override
	public ArrayList<Map<String,Object>> getReport(int mon_id) {
		List<Subject> subjects = subjectRepository.getSubject();
		return rep.getReport(subjects, mon_id);
	}

}
