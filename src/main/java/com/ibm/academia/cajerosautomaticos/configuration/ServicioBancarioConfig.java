package com.ibm.academia.cajerosautomaticos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServicioBancarioConfig {
	
	@Bean("clienteRest")
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
