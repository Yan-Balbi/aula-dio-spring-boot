package edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.dto.LoginDto;
import edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.dto.Sessao;
import edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.model.Usuario;
import edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.repository.UsuarioRepository;
import edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.security.JWTCreator;
import edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.security.JWTObject;
import edu.yan.springboot.webapi.exemplos.exemplo4autenticacaoJWT.security.SecurityConfig;

@RestController
public class LoginController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/login")
    public Sessao logar(@RequestBody LoginDto login){
        Usuario usuario = repository.findByNomeUsuario(login.getNomeUsuario());
        if(usuario!=null) {
            boolean passwordOk =  encoder.matches(login.getSenha(), usuario.getSenha());
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.getNomeUsuario());
            }
            //Estamos enviando um objeto Sessão para retornar mais informações do usuário
            Sessao sessao = new Sessao();
            sessao.setLogin(usuario.getNomeUsuario());

            JWTObject jwtObject = new JWTObject();
            jwtObject.getDataCriacaoToken();
            jwtObject.setDataDeExpiracaoToken(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION));
            jwtObject.setPapeis(usuario.getPapeis());
            sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return sessao;
        }else {
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }
}
