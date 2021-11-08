package io.javabrains.springboot.course;
 

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springboot.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService CourseService;
	@RequestMapping("/topic/{id}/courses") 
	public List<Course> getAllCourses(@PathVariable String id) {
		
		return CourseService.getAllCourses(id);
	}
	@RequestMapping("/topic/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return CourseService.getCourse(id);
	}
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/ourses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, ""," "));
		CourseService.addCourse(course);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/ourses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, ""," "));
		CourseService.updateCourse(course);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/ourses/{id}")
	public void deleteTopic(@RequestBody Course topic, @PathVariable String id) {
		CourseService.deleteCourse(id);
	}
}
