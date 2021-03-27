package com.mydemo.applications;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.mydemo.applications.mapper")
public class ApplicationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationsApplication.class, args);
	}

}
