package com.log.eurekaserver

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@EnableEurekaServer
@SpringBootApplication
class EurekaServerApplication {
 
	static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication, args)
	} 
	

}
