//package com.jonathan.hrpayroll.config;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.cloud.client.DefaultServiceInstance;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
//
//import reactor.core.publisher.Flux;
//
//// Para informar as instencias disponíveis de forma hardcoded
//public class DemonInstanceSupplier implements ServiceInstanceListSupplier {
//	private final String serviceId;
//	
//	public DemonInstanceSupplier(String serviceId) {
//		this.serviceId = serviceId;
//	}
//	
//	@Override
//	public Flux<List<ServiceInstance>> get() {
//		return Flux.just(Arrays.asList(new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 8001, false), 
//				new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 8002, false)));
//	}
//
//	@Override
//	public String getServiceId() {
//		return serviceId;
//	}
//
//}
