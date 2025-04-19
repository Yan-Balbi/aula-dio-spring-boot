package edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	@GetMapping
	public String welcome() {
		return "Welcome";
	}
	
	@GetMapping("/users")
	public String users() {
		return "Usuarios";
	}
	
	@GetMapping("/managers")
	public String managers() {
		return "Gerente";
	}
}
