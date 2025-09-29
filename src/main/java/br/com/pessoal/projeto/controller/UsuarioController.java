package br.com.pessoal.projeto.controller;

import br.com.pessoal.projeto.dto.UsuarioDto;
import br.com.pessoal.projeto.entity.UsuarioEntity;
import br.com.pessoal.projeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping
    public List<UsuarioDto> ListarTodos() {
        return usuarioService.ListarTodos();
    }
    @PostMapping
    public void AdicionarUsuario(@RequestBody UsuarioDto usuario) {
        UsuarioEntity usuarioentity = new UsuarioEntity(usuario);
        usuarioentity.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioService.InserirUsuario(new UsuarioDto(usuarioentity));
    }
    @PutMapping
    public UsuarioDto AtualizarUsuario(@RequestBody UsuarioDto usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioService.AtualizarUsuario(new UsuarioDto(usuarioEntity));
    }
    @DeleteMapping
    public ResponseEntity<Void> deletar(@PathVariable("id") long id) {
        usuarioService.DeletarUsuario(id);
        return ResponseEntity.ok().build();
    }
}
