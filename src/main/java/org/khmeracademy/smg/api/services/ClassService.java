package org.khmeracademy.smg.api.services;

import java.util.ArrayList;
import org.khmeracademy.smg.api.model.Class;

public interface ClassService {
	public ArrayList<Class> getClassByCourse(int cou_id);
	public boolean addClass(Class className);
	public Class getClassById(int cla_id);
	public boolean updateClass(Class clas);
	public boolean disabledCourse(Class cla);
}
