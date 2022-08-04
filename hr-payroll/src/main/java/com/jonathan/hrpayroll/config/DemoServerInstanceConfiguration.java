package com.jonathan.hrpayroll.config;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoServerInstanceConfiguration {
	@Bean
	ServiceInstanceListSupplier serviceInstanceListSupplier() {
		return new DemonInstanceSupplier("hr-worker");
	}
}
