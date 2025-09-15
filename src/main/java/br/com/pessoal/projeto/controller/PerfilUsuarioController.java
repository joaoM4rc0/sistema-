package br.com.pessoal.projeto.controller;

import br.com.pessoal.projeto.dto.PerfilUsuarioDto;
import br.com.pessoal.projeto.dto.UsuarioDto;
import br.com.pessoal.projeto.service.PerfilUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil-usuario")
@CrossOrigin
public class PerfilUsuarioController {
    @Autowired
    private PerfilUsuarioService perfilUsuarioService;
    @GetMapping
    public List<PerfilUsuarioDto> ListarTodos() {
        return perfilUsuarioService.Listar();
    }
    @PostMapping
    public void Adicionar(@RequestBody PerfilUsuarioDto perfilUsuario) {
        perfilUsuarioService.Adicionar(perfilUsuario);
    }
    @PutMapping
    public PerfilUsuarioDto AtualizarUsuario(@RequestBody PerfilUsuarioDto perfilUsuario) {
        return perfilUsuarioService.Atualizar(perfilUsuario);
    }
    @DeleteMapping
    public ResponseEntity<Void> deletar(@PathVariable("id") long id) {
        perfilUsuarioService.Deletar(id);
        return ResponseEntity.ok().build();
    }
}
