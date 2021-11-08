 package io.javabrains.springboot.course; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courserepository;
	
	
	public List<Course>getAllCourses(String id){
		List<Course>courses = new ArrayList<>();
		courserepository.findAll()
		.forEach(courses::add);
		return courses;
	}
	public Course getCourse(String id) {
		 return courserepository.findById(id).get();
	}
	public void addCourse(Course course) {
		courserepository.save(course);
	}
	public void updateCourse( Course topic) {
		courserepository.save(topic);
	}
	public void deleteCourse(String id) {
		// TODO Auto-generated method stub
		courserepository.deleteById(id);
	}
	
	
	
	
	
}
