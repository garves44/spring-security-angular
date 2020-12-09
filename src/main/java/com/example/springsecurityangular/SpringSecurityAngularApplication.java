package com.example.springsecurityangular;

import java.util.Map;
import java.security.Principal;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class SpringSecurityAngularApplication {

	@GetMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

	@GetMapping("/resource")
	@ResponseBody
	public Map<String, Object> home() {
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("id", UUID.randomUUID().toString());
	  model.put("content", "Hello World");
	  return model;
	}
  
	@GetMapping(value = "/{path:[^\\.]*}")
	public String redirect() {
	  return "forward:/";
	}

	@Configuration
	@Order(SecurityProperties.ACCESS__OVERIRDE_ORDER)
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter
	{
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.httpBasic()
			.and()
				.authorizeRequests()
					.anyMatchers("/index.html", "/", "/home", "/login").permitAll()
					.anyRequest().authenticated();	
		}			
	}

  
	public static void main(String[] args) {
	  SpringApplication.run(SpringSecurityAngularApplication.class, args);
	}
  }
