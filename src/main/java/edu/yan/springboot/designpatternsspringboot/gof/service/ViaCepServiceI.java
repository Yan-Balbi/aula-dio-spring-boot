package edu.yan.springboot.designpatternsspringboot.gof.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.yan.springboot.designpatternsspringboot.gof.model.Endereco;

/**
 * 	Acessando a api viaCep
 */

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepServiceI {

	@GetMapping(value = "/{cep}/json/")
	Endereco consultarCep(@PathVariable("cep") String cep);
	
}
