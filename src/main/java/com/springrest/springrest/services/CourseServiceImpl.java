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

	@Override
	public Course deleteCourse(long courseId) {
		Course ans=null;
		for(Course course:list) {
			if (course.getId() == courseId) {
				ans=course;
				list.remove(course);
			}
		}
		return ans;
	}

	@Override
	public Course updateCourse(Course course) {
		list.forEach(e -> {
			if(e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		return course;
	}

}
