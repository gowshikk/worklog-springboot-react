package com.poc.worklog.service.exception

class AppUserNotFoundException extends Exception {
	
	public AppUserNotFoundException()
	{
		super();
	}
	
	public AppUserNotFoundException(final String message)
	{
		super(message);
	}
	
}
