package io.javabrains.springbootstarter.lessons;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.course.Course;
import io.javabrains.springbootstarter.topic.Topic;

@Service
public class LessonService {

	/**List<Topic> topics=new ArrayList<>(Arrays.asList(
			new Topic("SPRING","SPRING FRAMWEORK", "SPRING FRAMWEORK Description"),
			new Topic("jAVA","Java FRAMWEORK", "java FRAMWEORK Description"),
			new Topic("CSS","css FRAMWEORK", "CSS FRAMWEORK  Description")
			));
	**/
	
	@Autowired
	private LessonRepository lessonRepository;

	public List<Lesson> getAllLessons(String topicId, String courseId) {
		
		return lessonRepository.findByTopicIdAndCourseId(topicId,courseId);
	}

	public Lesson getLesson(String lessonId) {
		return lessonRepository.findOne(lessonId);
	}

	public void addLesson(Lesson lesson, String topicId, String courseId) {
		lesson.setCourse(new Course(courseId, "", "", topicId));
		//lesson.setTopic(new Topic(topicId,"",""));
		lessonRepository.save(lesson);
		
	}

	public void updateLesson(Lesson lesson, String topicId, String courseId) {
		lesson.setCourse(new Course(courseId, "", "", topicId));
		//lesson.setTopic(new Topic(topicId,"",""));
		lessonRepository.save(lesson);
	}

	public void deleteLesson(String lessonId) {
		lessonRepository.delete(lessonId);
		
	}
	
	
}
