package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	@RestController
	class SimpleController {
		
		@Value("${eureka.instance.metadataMap.zone}")
		private String zone;
		
		@GetMapping(value = "/zone", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public String zone() {
			String string = "{\"zone\":\""+zone+"\"}";
			System.out.println("Data Returned: "+string);
			return string;
		}
		
		@GetMapping(value = "/dummy service/data", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public String carCareTest() {
			String string = "{\"dummy service\":\"data\"}";
			System.out.println("Data Returned: "+string);
			return string;
		}
		
		
	}
}
