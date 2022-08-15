package com.jonathan.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathan.hrpayroll.entities.Payment;
import com.jonathan.hrpayroll.entities.Worker;
import com.jonathan.hrpayroll.feignclients.WorkerFeignClient;

@Service // Tratar classe como componente do spring
public class PaymenteService {
	
//	@Value("${hr-worker.host}")
//	private String workerHost; // Armazena o valor da propriedade na variável
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(Long workerId, int days) {
//		Map<String, String> uriVariables = new HashMap<>();
//		uriVariables.put("id", ""+workerId);
		
//		Worker worker = restTemplate.getForObject(workerHost+"/workers/{id}", Worker.class, uriVariables);
		
		Worker worker = workerFeignClient.findById(workerId).getBody(); // Realiza a busca do objeto worker no projeto hr-worker
		return new Payment(worker.getName(), worker.getDailyIncome(), days); // o objeto worker tem suas informações adicionadas ao objeto payment
	}
}
