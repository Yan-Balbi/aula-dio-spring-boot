package edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
	
	@Query("SELECT u FROM Usuario u JOIN FETCH u.papeis WHERE u.nomeUsuario = (:nome_usuario)")
	public Usuario findByNomeUsuario(@Param("nome_usuario") String nomeUsuario);
	
	boolean existsByNomeUsuario(String nomeUsuario);
}
