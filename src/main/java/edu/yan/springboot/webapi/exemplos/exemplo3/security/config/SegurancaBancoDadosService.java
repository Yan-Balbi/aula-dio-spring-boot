package edu.yan.springboot.webapi.exemplos.exemplo3.security.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.UserDetailsAwareConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.yan.springboot.webapi.exemplos.exemplo3.security.model.Usuario;
import edu.yan.springboot.webapi.exemplos.exemplo3.security.repository.UsuarioRepository;

@Service
public class SegurancaBancoDadosService implements UserDetailsService{
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {
		
		Usuario usuarioEntity = usuarioRepository.findByUsuario(nomeUsuario);
		
		if(usuarioEntity == null) {
			throw new UsernameNotFoundException(nomeUsuario);
		} 
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		usuarioEntity.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role));//O objeto GrantedAuthority exige o 'ROLE'+nome_do_papel
		});
		UserDetails usuario = new User(usuarioEntity.getUsuario(), usuarioEntity.getSenha(), authorities);
		return usuario;
	}
	
}
