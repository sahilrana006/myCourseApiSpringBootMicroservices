package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	/**List<Topic> topics=new ArrayList<>(Arrays.asList(
			new Topic("SPRING","SPRING FRAMWEORK", "SPRING FRAMWEORK Description"),
			new Topic("jAVA","Java FRAMWEORK", "java FRAMWEORK Description"),
			new Topic("CSS","css FRAMWEORK", "CSS FRAMWEORK  Description")
			));
	**/
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId){
		 List<Course> courses=new ArrayList<Course>();
		 courseRepository.findByTopicId(topicId).forEach(c->courses.add(c));
		 return courses;
	}

	public Course getCourse(String id) {
		return courseRepository.findOne(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
		
	}
	
	public void updateCourse(Course course) {
		courseRepository.save(course);
		
	}
	
	public void deleteCourse(String id){
		courseRepository.delete(id);
	}
}
