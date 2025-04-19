package edu.yan.springboot.webapi.exemplos.exemplo2.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.yan.springboot.webapi.exemplos.exemplo2.handler.BusinessException;
import edu.yan.springboot.webapi.exemplos.exemplo2.handler.CampoObrigatorioException;
import edu.yan.springboot.webapi.exemplos.exemplo2.model.Usuario;

@Repository
public class UsuarioRepository {
	public void salvar(Usuario usuario) {
		if(usuario.getLogin()==(null)) {
//			throw new BusinessException("O campo login é obrigatório");
			throw new CampoObrigatorioException("login");
		}
		
		if(usuario.getSenha()==(null)) {
			throw new CampoObrigatorioException("senha");
		}
		System.out.println("Salvando usuario "+usuario.toString());
	}
	
	public void atualizar(Usuario usuario) {
		if(usuario.getLogin()==	(null))
			throw new BusinessException("O campo login é obrigatório");
		System.out.println("Atualizando usuario "+usuario.toString());
	}
	
	public void deletar(Usuario usuario) {
		
		System.out.println("Deletando usuario "+usuario.toString());
	}
	
	public void deleteById(Integer id) {
		System.out.println("Deletando usuario de id "+id);
	}
	
	public List<Usuario> findAll(){
		List<Usuario> usuarios = List.of(new Usuario("Jão","123"), new Usuario("Pedro","456"));
		return usuarios;
	}
	
	public Usuario findById(Integer id){
		return new Usuario("Jao","123");
	}
	
	public Usuario findByUsername(String nome) {
		return new Usuario("Jao","123");
	}
	
	
}
