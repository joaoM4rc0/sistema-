package br.com.pessoal.projeto.service;

import br.com.pessoal.projeto.Security.jwt.JwtUtils;
import br.com.pessoal.projeto.dto.AcessDto;
import br.com.pessoal.projeto.dto.AuthenticationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;
    public AcessDto login(AuthenticationDto authDto) {
        try {
            // cria mecanismo de credencial para o spring
            UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(
                    authDto.getUsername(), authDto.getPassword()
            );
            // prepara mecanismo para autenticação
            Authentication authentication = authenticationManager.authenticate(userAuth);
            // busca usuario logado
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            var token = jwtUtils.GenerateTokenFromUserDetailsImpl(userDetails);
            return new AcessDto(token);
        }catch (BadCredentialsException e) {
            System.out.println(e);
        }
        return new AcessDto("Acesso negado");
    }
}
