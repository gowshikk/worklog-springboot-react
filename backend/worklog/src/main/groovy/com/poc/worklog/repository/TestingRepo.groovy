package com.poc.worklog.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

import com.poc.worklog.models.TestingModel

@Repository
interface TestingRepo extends MongoRepository<TestingModel,Integer>{
}
