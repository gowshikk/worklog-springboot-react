package com.poc.worklog.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.poc.worklog.models.TestingModel
import com.poc.worklog.repository.TestingRepo

@RestController
@RequestMapping("/test")
class TestingController {

	@Autowired
	private TestingRepo testrepo;

	@GetMapping("/findall")
	public List<TestingModel> getAll() {
		return testrepo.findAll();
	}

	@GetMapping("/save")
	public String save() {

		TestingModel test = new TestingModel("Gowshik", "Java Programming");
		testrepo.save(test);
		TestingModel test2 = new TestingModel("Jagajeet", "C Programming");
		//test2.setId(1);
		testrepo.save(test2);
		return "saved";
	}
}
