package org.khmeracademy.smg.api.services;

import java.util.ArrayList;

import org.khmeracademy.smg.api.model.Course;

public interface CourseService {
	public boolean addCourse(Course course);
	public ArrayList<Course> getCourseByGeneration(int gen_id);
}
