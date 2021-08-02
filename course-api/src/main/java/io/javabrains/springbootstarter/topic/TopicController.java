package io.javabrains.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/topics")
public class TopicController {

	
	@Autowired
	private TopicService topicService;
	
	/**
	 * Response will be converted to JSON Automatically and sends back as HTTP response.
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/")
	@ApiOperation(value="Get All Topics",
	               notes="Get all the topics",
	               response=Topic.class)
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{foo}")
	@ApiOperation(value="Get Topic by Topic Id",
    response=Topic.class)
	public Topic getTopic(@ApiParam(value="ID value of the topic that you wishes to receive", required=true)@PathVariable("foo") String id)
	throws Exception{
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/")
	@ApiOperation(value="Add a new Topic")
	public void addTopic(@ApiParam(value="PAYLOAD OF TOPIC",required=true)@RequestBody Topic topic){
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/")
	@ApiOperation(value="Updates the Topic")
	public void updateTopic(@ApiParam(value="Payload of Topic")@RequestBody Topic topic){
		topicService.updateTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	@ApiOperation(value="Deletes a topic by topicId")
	public void addTopic(@ApiParam(value="Topic Id of Topic",required=true)@PathVariable String id){
		topicService.deleteTopic(id);
	}
}
