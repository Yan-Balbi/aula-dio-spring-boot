package edu.yan.springboot.designpatternsspringboot.gof.service;

import java.util.Optional;

import edu.yan.springboot.designpatternsspringboot.gof.model.Cliente;

public interface ClienteServiceI {
	Iterable<Cliente> buscarTodos();
	
	Optional<Cliente> buscarPorId(Long id);
	
	void inserir(Cliente cliente);
	
	void atualizar(Cliente cliente);

	void deletar(Long id);
}
