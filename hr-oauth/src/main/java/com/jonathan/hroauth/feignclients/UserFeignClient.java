package com.jonathan.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jonathan.hroauth.entities.User;

@Component
//@FeignClient(name = "hr-user", path = "/users")
@FeignClient(name = "hr-user",url = "http://localhost:8765/users")
public interface UserFeignClient {

	@GetMapping(value = "/search")
	ResponseEntity<User> findByEmail(@RequestParam String email);
}
