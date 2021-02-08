package com.poc.worklog

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@EnableEurekaClient
@SpringBootApplication
class WorklogApplication {

	static void main(String[] args) {
		SpringApplication.run(WorklogApplication, args)

	}

}
