package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	/**List<Topic> topics=new ArrayList<>(Arrays.asList(
			new Topic("SPRING","SPRING FRAMWEORK", "SPRING FRAMWEORK Description"),
			new Topic("jAVA","Java FRAMWEORK", "java FRAMWEORK Description"),
			new Topic("CSS","css FRAMWEORK", "CSS FRAMWEORK  Description")
			));
	**/
	

	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics() throws NullPointerException {
		List<Topic> topics=new ArrayList<Topic>();
		try{ 
			if( topicRepository.findAll()!=null){
					topicRepository.findAll().forEach(t->topics.add(t));
			 }
		}
		catch(NullPointerException e){
			throw new NullPointerException("topic repository is not intialized");
		}
		return topics;
	}

	public Topic getTopic(String id) throws NullPointerException  {
		try{
			 if(topicRepository.findOne(id.toLowerCase())!=null || !topicRepository.findOne(id.toLowerCase()).toString().isEmpty()){
				 return topicRepository.findOne(id.toLowerCase());
			 }
			
		}catch(Exception e){
			throw new NullPointerException("topic name is invalid");
		}
		return null;
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
	}
	
	public void updateTopic(Topic topic) {
		topicRepository.save(topic);
		
	}
	
	public void deleteTopic(String id){
		topicRepository.delete(id);
	}
}
