	package edu.yan.springboot.webapi.exemplos.exemplo3.security.controller;
	
	import org.springframework.security.access.prepost.PreAuthorize;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RestController;
	
	@RestController
	public class WelcomeController {
		@GetMapping
		public String home() {
			return "home";
		}
		
		@GetMapping("/usuario")
//		@PreAuthorize("hasAnyRole('ADMIN','USER')")
		public String usuarios() {
			return "usuarios";
		}
		
		@GetMapping("/admin")
//		@PreAuthorize("hasRole('ADMIN')")
		public String administradores() {
			return "administradores";
		}
		
	}
