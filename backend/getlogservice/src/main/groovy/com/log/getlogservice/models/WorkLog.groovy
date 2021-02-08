package com.log.getlogservice.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class WorkLog implements Serializable{
	
	@Id
	private String id;	
	private String name;
	private String project;
	private String position;
//	private String logDescription;
//	private String hoursWorked;
	private ArrayList<LogDetail> logDetails;
	
	

	public WorkLog() {
		super();
	}

	public WorkLog(String name, String project, String position, ArrayList<LogDetail> logDetails) {
		super();
		this.name = name;
		this.project = project;
		this.position = position;
		this.logDetails = logDetails;
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

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public ArrayList<LogDetail> getLogDetails() {
		return logDetails;
	}

	public void setLogDetails(ArrayList<LogDetail> logDetails) {
		this.logDetails = logDetails;
	}

	@Override
	public String toString() {
		return "WorkLog [id=" + id + ", name=" + name + ", project=" + project + ", position=" + position
				+ ", logDetails=" + logDetails + "]";
	}

	
	

}
