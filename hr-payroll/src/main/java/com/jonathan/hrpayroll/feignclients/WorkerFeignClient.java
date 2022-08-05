package com.jonathan.hrpayroll.feignclients;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jonathan.hrpayroll.config.DemoServerInstanceConfiguration;
import com.jonathan.hrpayroll.entities.Worker;
// Para se comunicar com outros projetos
@Component
@FeignClient(name = "hr-worker", path = "/workers")
//@LoadBalancerClient(name = "hr-worker", configuration = DemoServerInstanceConfiguration.class)// Configuração do LoadBalance - desabilitado devido ao eureka
public interface WorkerFeignClient {
	
	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);
}
