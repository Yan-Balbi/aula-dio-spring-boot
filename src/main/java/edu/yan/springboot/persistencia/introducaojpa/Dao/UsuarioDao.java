package edu.yan.springboot.persistencia.introducaojpa.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.yan.springboot.persistencia.introducaojpa.Model.UsuarioModel;

public interface UsuarioDao extends JpaRepository<UsuarioModel, Integer>{
	@Query("SELECT u FROM UsuarioModel u WHERE u.nome LIKE %:nome%")
	List<UsuarioModel> filtrarPorNome(@Param("nome") String name);
}
