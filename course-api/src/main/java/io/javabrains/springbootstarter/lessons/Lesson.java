package io.javabrains.springbootstarter.lessons;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import io.javabrains.springbootstarter.course.Course;
import io.javabrains.springbootstarter.topic.Topic;

@Entity
public class Lesson {

	@Id
	private String lessonId;
	
	private String lessonName;
	
	private String lessonDescription;
	
	@ManyToOne
	private Course course;
	
	@ManyToOne
	private Topic topic;
	

	public Lesson(){
		
	}
	
	public Lesson(String lessonId,String lessonName,String lessonDescription,String courseId,String topicId){
		super();
		this.lessonId=lessonId;
		this.lessonName=lessonName;
		this.lessonDescription=lessonDescription;
		this.course=new Course(courseId,"","",topicId);
		this.topic=new Topic(topicId,"","");
	}
	public String getLessonId() {
		return lessonId;
	}
	public void setId(String lessonId) {
		this.lessonId = lessonId;
	}
	public String getLessonName() {
		return lessonName;
	}
	public void setName(String lessonName) {
		this.lessonName = lessonName;
	}
	public String getLessonDescription() {
		return lessonDescription;
	}
	public void setDescription(String lessonDescription) {
		this.lessonDescription = lessonDescription;
	}
	
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
