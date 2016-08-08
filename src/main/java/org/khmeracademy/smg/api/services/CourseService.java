package org.khmeracademy.smg.api.services;

import java.util.ArrayList;

import org.khmeracademy.smg.api.model.Course;

public interface CourseService {
	public boolean addCourse(Course course);
	public ArrayList<Course> getCourseByGeneration(int gen_id);
	public Course getCourseById(int cou_id);
	public boolean updateCourse(Course course);
	public boolean disabledCourse(Course course);
	public Course courseNotFinish(boolean cou_is_finish);
}
