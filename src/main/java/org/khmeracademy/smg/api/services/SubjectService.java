package org.khmeracademy.smg.api.services;

import java.util.ArrayList;
import org.khmeracademy.smg.api.model.Subject;

public interface SubjectService {
	public ArrayList<Subject> getSubject();
	public Subject getSubjectById(int sub_id);
	public boolean insertSubject(Subject subject);
	public boolean updateSubject(Subject subject);
	public boolean deleteDisableSubject(Subject subject);
}
