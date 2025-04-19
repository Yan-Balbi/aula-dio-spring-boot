package edu.yan.springboot.primeirospassos.configurationproperties;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
//como estamos usando o remetente como uma configuração, ele não será um Component, e sim um Configuration
@Configuration
@ConfigurationProperties(prefix="remetente")
public class Remetente {
	private String nome;
	private String email;
	private List<Long> telefones;
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Long> getTelefones(){
		return this.telefones;
	}
	
	public void setTelefones(List<Long> telefones) {
	    this.telefones = telefones;
	}
	
	
}
