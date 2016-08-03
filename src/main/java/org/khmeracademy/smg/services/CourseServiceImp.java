package org.khmeracademy.smg.services;

import org.khmeracademy.smg.model.Course;
import org.khmeracademy.smg.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImp implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public boolean addCourse(Course course) {
		return courseRepository.addCourse(course);
	}

}
