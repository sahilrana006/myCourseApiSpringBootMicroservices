package io.javabrains.springbootstarter.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="Details about the topic")
public class Topic {

	@Id
	@ApiModelProperty(notes="Unique id of the topic")
	private String id;
	
	@ApiModelProperty(notes="Name of the topic")
	private String name;
	
	@ApiModelProperty(notes="Description the topic")
	private String description;
	
	
	public Topic(){
		
	}
	
	public Topic(String id,String name,String description){
		super();
		this.id=id;
		this.name=name;
		this.description=description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
