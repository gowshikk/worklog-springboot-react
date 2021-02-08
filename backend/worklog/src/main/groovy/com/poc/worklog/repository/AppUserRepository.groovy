package com.poc.worklog.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

import com.poc.worklog.models.AppUser

@Repository
interface AppUserRepository extends MongoRepository<AppUser,String>{
	
	public AppUser findByUsername(String name);
}
