package edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.model.Usuario;
import edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public void createUsuario(Usuario usuario) {
		String senha = usuario.getSenha();
		usuario.setSenha(encoder.encode(senha));
		usuarioRepository.save(usuario);
	}
}
