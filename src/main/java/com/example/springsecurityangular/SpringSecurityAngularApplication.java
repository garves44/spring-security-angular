package com.example.springsecurityangular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Controller
public class SpringSecurityAngularApplication {

	@GetMapping("/resource")
	@ResponseBody
	public Map<String, Object> main(String[] args) {
		Map<String, Object> model = new HashMap<String, Object>();
    	model.put("id", UUID.randomUUID().toString());
    	model.put("content", "Hello World");
    	return model;
	}

}
