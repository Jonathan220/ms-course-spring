package com.jonathan.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	// Cria uma classe singleton, classe que é instanciada uma única vez e fica disponível para outras classes
	// A anotação bean garante que a classe restTemplate é instanciada uma única vez através do método
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
