package com.rakesh;
/**
-File Name          : PatientTrackerSystemJPAApplication
-Author Name        : Rakesh Choudhary
-Description        : PatientTrackerSystemJPAApplication Application class
-Creation Date		: 12/04/2021
-Last Modified Date : 12/04/2021
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
public class PatientTrackerSystemJPAApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientTrackerSystemJPAApplication.class, args);
	}

	@Bean
	public Docket employeeAPI() {
	return new Docket(DocumentationType.SWAGGER_2)
	.select()
	.apis(RequestHandlerSelectors.basePackage("com.rakesh.controller"))
	.build();
	}
	
}
