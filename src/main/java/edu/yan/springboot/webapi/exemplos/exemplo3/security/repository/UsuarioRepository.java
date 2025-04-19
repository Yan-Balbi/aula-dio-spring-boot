package edu.yan.springboot.webapi.exemplos.exemplo3.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.yan.springboot.webapi.exemplos.exemplo3.security.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	@Query("SELECT u FROM Usuario u JOIN FETCH u.roles WHERE u.nomeUsuario= (:usuario)")//o Usuario é maiusculo porque ele busca o nome da classe, e não da tabela
	public Usuario findByUsuario(@Param("usuario") String usuario);
}
