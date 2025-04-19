package edu.yan.springboot.webapi.exemplos.exemplo3.security.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table (name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(length = 20, nullable = false, name = "nome_usuario")
	private String nomeUsuario;
	
	@Column(length = 100, nullable = false)
	private String senha;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "usuario_has_papeis", joinColumns = @JoinColumn(name = "usuario_id"))
	@Column(name = "role_id")
	private List<String> roles = new ArrayList<>();
	
	public Usuario() {
		
	}
	
	public Usuario(String usuario) {
		this.nomeUsuario = usuario;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setUsuario(String usuario) {
		this.nomeUsuario = usuario;
	}
	
	public String getUsuario() {
		return this.nomeUsuario;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	public List<String> getRoles() {
		return this.roles;
	}
	
}
