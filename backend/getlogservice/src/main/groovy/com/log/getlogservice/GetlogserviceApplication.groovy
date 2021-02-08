package com.log.getlogservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@EnableEurekaClient
@SpringBootApplication
class GetlogserviceApplication implements WebMvcConfigurer {

	static void main(String[] args) {
		SpringApplication.run(GetlogserviceApplication, args)
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedHeaders("Authorization", "Cache-Control", "Content-Type", "Accept", "X-Requested-With", "Access-Control-Allow-Origin", "Access-Control-Allow-Headers", "Origin")
				.exposedHeaders("Access-Control-Expose-Headers", "Authorization", "Cache-Control", "Content-Type", "Access-Control-Allow-Origin", "Access-Control-Allow-Headers", "Origin")
				.allowedMethods("GET", "OPTIONS", "POST", "PUT", "DELETE", "PATCH").allowedOrigins("http://localhost:3000");
	}
}
