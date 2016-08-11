package org.khmeracademy.smg.api.services;

import java.util.ArrayList;

import org.khmeracademy.smg.api.model.Subject;
import org.khmeracademy.smg.api.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImp implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Override
	public ArrayList<Subject> getSubject() {
		return subjectRepository.getSubject();
	}

	@Override
	public boolean insertSubject(Subject subject) {
		return subjectRepository.insertSubject(subject);
	}

	@Override
	public boolean updateSubject(Subject subject) {
		return subjectRepository.updateSubject(subject);
	}

	@Override
	public boolean deleteDisableSubject(Subject subject) {
		return subjectRepository.deleteDisableSubject(subject);
	}

	@Override
	public Subject getSubjectById(int sub_id) {
		return subjectRepository.getSubjectById(sub_id);
	}

}
