package io.javabrains.springbootstarter.lessons;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/topics")
public class LessonController {

	
	@Autowired
	private LessonService lessonService;
	
	/**
	 * Response will be converted to JSON Automatically and sends back as HTTP response.
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/{topicId}/courses/{courseId}/lessons")
	public List<Lesson> getAllCourses(@PathVariable String topicId,@PathVariable String courseId){
		return lessonService.getAllLessons(topicId,courseId);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public Lesson getCourse(@PathVariable("lessonId") String lessonId){
		return lessonService.getLesson(lessonId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/{topicId}/courses/{courseId}/lessons")
	public void addCourse(@RequestBody Lesson lesson, @PathVariable String topicId,@PathVariable String courseId){
		lessonService.addLesson(lesson,topicId,courseId);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void updateTopic(@RequestBody Lesson lesson, @PathVariable String topicId,@PathVariable String courseId){
		lessonService.updateLesson(lesson,topicId,courseId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void addTopic(@PathVariable String lessonId){
		lessonService.deleteLesson(lessonId);
	}
}
