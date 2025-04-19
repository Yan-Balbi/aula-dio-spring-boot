package edu.yan.springboot.webapi.exemplos.exemplo1.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AplicacaoController {
	
	@GetMapping
	public String teste() {
		return "entrou";
	}
}
