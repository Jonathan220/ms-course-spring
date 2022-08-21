package com.jonathan.hrpayroll.config;

import java.time.Duration;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;


@Configuration
public class FeignConfiguration {
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> circuitBreakerFactoryCustomizer(){
		CircuitBreakerConfig cbConfig = CircuitBreakerConfig.custom()
				.slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
				.slidingWindowSize(5)
				.failureRateThreshold(20.0f)
				.waitDurationInOpenState(Duration.ofSeconds(5))
				.permittedNumberOfCallsInHalfOpenState(5)
				.writableStackTraceEnabled(false)
				.build();
		
		TimeLimiterConfig config = TimeLimiterConfig.custom()
				   .cancelRunningFuture(true)
				   .timeoutDuration(Duration.ofMillis(4000L))
				   .build();
		
//		TimeLimiterRegistry timeLimiterRegistry = TimeLimiterRegistry.of(config);
//		
//		CircuitBreakerRegistry circuitBreakerRegistry = CircuitBreakerRegistry.of(cbConfig);
//		
//		CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("circuitBreaker");
//		
//		Supplier<Worker> supplierWorker = () -> new Worker(1L, "Brann", 300.0);
//		
//		Supplier<Worker> decoratedSupplier = CircuitBreaker.decorateSupplier(circuitBreaker, supplierWorker);
//		
//		
//		return resilience4JCircuitBreakerFactory -> resilience4JCircuitBreakerFactory.builder(decoratedSupplier);
		return resilience4JCircuitBreakerFactory -> resilience4JCircuitBreakerFactory.configure(builder -> builder.circuitBreakerConfig(cbConfig)
				.timeLimiterConfig(config),"WorkerFeignClient#findById(Long)");
		
	}
	
}
