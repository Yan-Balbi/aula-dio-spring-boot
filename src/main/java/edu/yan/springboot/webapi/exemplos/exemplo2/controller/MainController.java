package edu.yan.springboot.webapi.exemplos.exemplo2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.yan.springboot.webapi.exemplos.exemplo2.model.Usuario;

@RestController
public class MainController {
	@GetMapping
	public String obterRotaPrincipal(){
		return "rota principal";
	}
}
