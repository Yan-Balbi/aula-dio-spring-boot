package edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.security;

import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JWTCreator {
	   public static final String AUTORIZACAO_CABECALHO = "Authorization";
	    public static final String AUTORIDADES_PAPEIS = "authorities";

		/**
		 * Obtém um token a partir de um JWT Object
		 */
	    public static String create(String prefix,String key, JWTObject jwtObject) {
	        String token = Jwts.builder().setSubject(jwtObject.getUsuario()).setIssuedAt(jwtObject.getDataCriacaoToken()).setExpiration(jwtObject.getDataDeExpiracaoToken())
	                .claim(AUTORIDADES_PAPEIS, checkRoles(jwtObject.getPapeis())).signWith(SignatureAlgorithm.HS512, key).compact();
	        return prefix + " " + token;
	    }
	    
		/**
		 * Valida e decodifica um JWT Object assinado a partir de um token
		 */
	    public static JWTObject create(String token,String prefix,String key)
	            throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException {
	        JWTObject object = new JWTObject();
	        token = token.replace(prefix, "");// removendo o prefixo do token
	        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();//extraindo os dados do token
	        object.setUsuario(claims.getSubject());
	        object.setDataDeExpiracaoToken(claims.getExpiration());
	        object.setDataCriacaoToken(claims.getIssuedAt());
	        object.setPapeis((List) claims.get(AUTORIDADES_PAPEIS));
	        return object;

    	/**
    	 * Garante que o papel seja formatado corretamente, no formato ROLE_+nome_do_papel. Evita que a palavra ROLE_ fique repitida na frase ao fazer o replace
    	 */
	    }
	    private static List<String> checkRoles(List<String> roles) {
	        return roles.stream().map(s -> "ROLE_".concat(s.replaceAll("ROLE_",""))).collect(Collectors.toList());
	    }


}
