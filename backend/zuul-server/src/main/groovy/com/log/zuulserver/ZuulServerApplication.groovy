package com.log.zuulserver

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.config.server.EnableConfigServer
import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@EnableZuulProxy
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
class ZuulServerApplication  {

	static void main(String[] args) {
		SpringApplication.run(ZuulServerApplication, args)
	}
	
}
