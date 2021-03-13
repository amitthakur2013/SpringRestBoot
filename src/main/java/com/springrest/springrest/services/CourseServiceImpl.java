package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;
	public CourseServiceImpl() {
		 list=new ArrayList<>();
		 list.add(new Course(145,"Java Core","This is detailed desc of jva!"));
		 list.add(new Course(443,"Spring boot","This is desc of spring boot"));
	}
	
	@Override
	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		for(Course course:list) {
			if (course.getId() == courseId) return course;
		}
		return null;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

}
