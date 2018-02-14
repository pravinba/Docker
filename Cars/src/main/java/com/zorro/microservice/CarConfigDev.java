package com.zorro.microservice;

import java.util.Arrays;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
@Profile("default")
@PropertySource("classpath:/application.properties")
public class CarConfigDev {
	
	@Value("${insuranceAPI.uri}")
	private String insuranceAPI_uri;
	
	@Value("${insuranceAPI.key}")
	private String insuranceAPI_key;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		
		return builder.build();
	}
	
	@Bean
	public HttpHeaders httpHeader() {
		
		HttpHeaders httpHeaders =  new HttpHeaders();		
		byte[] encodedAuth = Base64.getEncoder().encode(insuranceAPI_key.getBytes());		
		String authHeader = "Basic " + new String(encodedAuth);
		httpHeaders.set("Authorization", authHeader);
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return httpHeaders;
	}
	


	
}
