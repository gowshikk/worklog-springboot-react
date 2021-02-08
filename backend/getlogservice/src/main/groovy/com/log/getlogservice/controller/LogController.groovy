package com.log.getlogservice.controller

import com.google.gson.Gson
import com.log.getlogservice.models.WorkLog
import com.log.getlogservice.repository.WorkLogRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:3000/*")
@RestController
@RefreshScope
@RequestMapping("/worklog")
class LogController {
	
	@Autowired
	private WorkLogRepository workLogRepository;
	
	@GetMapping("/list")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<WorkLog> listDetials(){
		List<WorkLog> c = workLogRepository.findAll();
		Gson gson = new Gson();
		String jsonCartList = gson.toJson(c);
		println jsonCartList
		return new ResponseEntity(jsonCartList,HttpStatus.OK);
	}
	
	@PostMapping("/saveForm")
	@CrossOrigin(origins = "http://localhost:3000")
	ResponseEntity<WorkLog> saveCard(@RequestBody WorkLog workLog) {
		///workLog.setId(1001);
		WorkLog result = workLogRepository.save(workLog);
		return new ResponseEntity<>(result , HttpStatus.ACCEPTED);
	}
}
