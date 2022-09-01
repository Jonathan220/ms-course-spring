package com.jonathan.hruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableDiscoveryClient
@SpringBootApplication
public class HrUserApplication{

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(HrUserApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
////		System.out.println("BCRYPT = " + passwordEncoder.encode("123456"));
//	}

}
