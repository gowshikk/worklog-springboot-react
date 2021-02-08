package com.log.getlogservice.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

import com.log.getlogservice.models.WorkLog

@Repository
interface WorkLogRepository extends MongoRepository<WorkLog,String>{
}
