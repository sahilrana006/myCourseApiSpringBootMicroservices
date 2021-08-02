package io.javabrains.springbootstarter.lessons;

import java.util.List;

import org.springframework.data.repository.CrudRepository;




public interface LessonRepository extends CrudRepository<Lesson, String> {

	public List<Lesson> findByTopicIdAndCourseId(String topicId, String courseId);
}
