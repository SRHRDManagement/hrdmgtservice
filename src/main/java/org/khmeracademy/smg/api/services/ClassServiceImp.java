package org.khmeracademy.smg.api.services;

import java.util.ArrayList;

import org.khmeracademy.smg.api.model.Class;
import org.khmeracademy.smg.api.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImp implements ClassService {

	@Autowired
	private ClassRepository classRepository;
	
	@Override
	public ArrayList<Class> getClassByCourse(int cou_id) {
		return classRepository.getClassByCourse(cou_id);
	}

	@Override
	public boolean addClass(Class className) {
		return classRepository.addClass(className);
	}

}
