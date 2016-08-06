package org.khmeracademy.smg.api.services;

import java.util.ArrayList;

import org.khmeracademy.smg.api.model.Course;
import org.khmeracademy.smg.api.repository.CourseRepository;
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

	@Override
	public ArrayList<Course> getCourseByGeneration(int gen_id) {
		return courseRepository.getCourseByGeneration(gen_id);
	}

}
