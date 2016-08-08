package org.khmeracademy.smg.api.services;

import java.util.ArrayList;

import org.khmeracademy.smg.api.model.Class;

public interface ClassService {
	public ArrayList<Class> getClassByCourse(int cou_id);
	public boolean addClass(Class className);
}
