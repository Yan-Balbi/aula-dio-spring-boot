package edu.yan.springboot.designpatternsspringboot.gof.service;

import edu.yan.springboot.designpatternsspringboot.gof.model.Cliente;
import edu.yan.springboot.designpatternsspringboot.gof.model.Endereco;

public interface EnderecoServiceI {
	Iterable<Endereco> buscarTodos();
	
	Cliente buscarPorId(Long id);
	
	void inserir(Endereco endereco);
	
	void atualizar(Endereco endereco);

	void deletar(Long id);
}
