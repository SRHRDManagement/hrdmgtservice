package org.khmeracademy.smg.api.services;

import java.util.ArrayList;
import java.util.Map;

import org.khmeracademy.smg.api.model.Month;
import org.khmeracademy.smg.api.model.Score;

public interface ScoreService {
	public ArrayList<Month> getAllMonths();
	public Month getMonthById(int mon_id);
	public ArrayList<Score> getScore(Score score);
	public boolean insertScore(Score score);
	ArrayList<Map<String, Object>> getReport(int mon_id);
}
