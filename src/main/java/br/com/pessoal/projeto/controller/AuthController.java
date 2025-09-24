package br.com.pessoal.projeto.controller;

import br.com.pessoal.projeto.dto.AuthenticationDto;
import br.com.pessoal.projeto.repository.UsuarioRepository;
import br.com.pessoal.projeto.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDto authentication) {
        return ResponseEntity.ok(authService.login(authentication));
    }
}
