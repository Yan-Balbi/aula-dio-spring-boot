	package edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.security;
	
	import org.springframework.boot.context.properties.ConfigurationProperties;
	import org.springframework.context.annotation.Configuration;
	
	/**
	 * Tem informações das credenciais de um usuário para poder fazer a geração do token
	 */
	@Configuration
	@ConfigurationProperties(prefix="security.config")
	public class SecurityConfig {
		public static String PREFIX;
		public static String KEY;
		public static Long EXPIRATION;
		
		public void setPrefix(String prefix) {
			this.PREFIX = prefix;
		}
		
		public void setKey(String key) {
			this.KEY = key;
		}
		
		public void setExpiration(Long expiracao) {
			this.EXPIRATION = expiracao;
		}
	}
