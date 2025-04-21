package edu.yan.springboot.designpatternsspringboot.gof.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.yan.springboot.designpatternsspringboot.gof.model.Cliente;
import edu.yan.springboot.designpatternsspringboot.gof.model.Endereco;
import edu.yan.springboot.designpatternsspringboot.gof.repository.ClienteRepository;
import edu.yan.springboot.designpatternsspringboot.gof.repository.EnderecoRepository;
import edu.yan.springboot.designpatternsspringboot.gof.service.ClienteServiceI;
import edu.yan.springboot.designpatternsspringboot.gof.service.ViaCepServiceI;
import edu.yan.springboot.primeirospassos.beanvscomponent.ViaCepResponse;

@Service
public class ClienteServiceImplementation implements ClienteServiceI{
	public Iterable<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	ViaCepServiceI viaCepService;

	@Override
	public Optional<Cliente> buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id);
	}

	@Override
	public void inserir(Cliente cliente) {
		Endereco endereco = enderecoRepository.findById(cliente.getEndereco().getCep()).orElseGet(() -> {//callback caso o Id não exista 
			//caso o cep não exista, salvar o retorno
			Endereco novoEndereco = viaCepService.consultarCep(cliente.getEndereco().getCep());
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);

	}

	@Override
	public void atualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		Optional<Cliente> clienteBd = clienteRepository.findById(cliente.getId());
		if(clienteBd.isPresent()) {
			inserir(cliente);
		}
			
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}
}
