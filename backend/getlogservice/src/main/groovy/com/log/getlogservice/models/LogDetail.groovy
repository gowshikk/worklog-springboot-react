package com.log.getlogservice.models

import java.text.DateFormat
import java.text.SimpleDateFormat

class LogDetail {
	private String log;
	private String hours;
	private String date;
	
	public LogDetail() {
		super();
	}
	
	public LogDetail(String log, String hours, String date) {
		super();
		this.log = log;
		this.hours = hours;
		this.date = date;
	}

	
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "LogDetail [log=" + log + ", hours=" + hours + ", date=" + date + "]";
	}
	
	
}
