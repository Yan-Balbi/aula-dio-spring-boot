package edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.security;

import java.util.Date;
import java.util.List;

/**Classe que representa um token
 * 
 */
public class JWTObject {
	private String usuario;
	private Date dataCriacaoToken;
	private Date dataDeExpiracaoToken;
	private List<String> papeis; //roles
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getDataCriacaoToken() {
		return dataCriacaoToken;
	}
	
	public void setDataCriacaoToken(Date dataCriacaoToken) {
		this.dataCriacaoToken = dataCriacaoToken;
	}
	public Date getDataDeExpiracaoToken() {
		return dataDeExpiracaoToken;
	}
	
	public void setDataDeExpiracaoToken(Date dataDeExpiracaoToken) {
		this.dataDeExpiracaoToken = dataDeExpiracaoToken;
	}
	
	public List<String> getPapeis() {
		return papeis;
	}
	public void setPapeis(List<String> papeis) {
		this.papeis = papeis;
	}
	
	
	
	
	
}
