package com.jonathan.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jonathan.hrpayroll.entities.Worker;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
//@LoadBalancerClient(name = "hr-worker", configuration = DemoServerInstanceConfiguration.class)// Configuração do LoadBalance - desabilitado devido ao eureka
public interface WorkerFeignClient {
	
	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);

	default ResponseEntity<Worker> fallback(Long id){
		Worker worker = new Worker(id, "Brann", 400.0);
		return ResponseEntity.ok(worker);
	}
}
