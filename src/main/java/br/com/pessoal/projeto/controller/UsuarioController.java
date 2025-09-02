package br.com.pessoal.projeto.controller;

import br.com.pessoal.projeto.dto.UsuarioDto;
import br.com.pessoal.projeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public List<UsuarioDto> ListarTodos() {
        return usuarioService.ListarTodos();
    }
    @PostMapping("/adicionar")
    public UsuarioDto AdicionarUsuario(@RequestBody UsuarioDto usuario) {
        return usuarioService.InserirUsuario(usuario);
    }
    @PutMapping("/atualizar")
    public UsuarioDto AtualizarUsuario(@RequestBody UsuarioDto usuario) {
        return usuarioService.AtualizarUsuario(usuario);
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") long id) {
        usuarioService.DeletarUsuario(id);
        return ResponseEntity.ok().build();
    }
}
