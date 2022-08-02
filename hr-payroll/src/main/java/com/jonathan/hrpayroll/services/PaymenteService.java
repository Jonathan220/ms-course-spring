package com.jonathan.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.jonathan.hrpayroll.entities.Payment;

@Service // Tratar classe como componente do spring
public class PaymenteService {
	
	public Payment getPayment(Long workerId, int days) {
		return new Payment("Bob", 200.0, days); // Dados mockados
	}
}
