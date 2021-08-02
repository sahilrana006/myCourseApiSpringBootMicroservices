package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
@RequestMapping("/topics")
public class CourseController {

	
	@Autowired
	private CourseService courseService;
	
	/**
	 * Response will be converted to JSON Automatically and sends back as HTTP response.
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, value="/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId){
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable("courseId") String courseId){
		return courseService.getCourse(courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/{topicId}/courses/")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId){
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/{topicId}/courses/{id}")
	public void updateTopic(@RequestBody Course course, @PathVariable String topicId){
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{topicId}/courses/{id}")
	public void addTopic(@PathVariable String id){
		courseService.deleteCourse(id);
	}
}
