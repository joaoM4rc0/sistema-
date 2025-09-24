package br.com.pessoal.projeto.controller;

import br.com.pessoal.projeto.dto.PermissaoPerfilRecursoDto;
import br.com.pessoal.projeto.service.PermissaoPerfilRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissaoPerfilRecurso")
@CrossOrigin
public class PermissaoPerfilRecursoController {
    @Autowired
    private PermissaoPerfilRecursoService permissaoPerfilRecursoService;
    @GetMapping
    public List<PermissaoPerfilRecursoDto> ListarTodos() {
        return permissaoPerfilRecursoService.Listar();
    }
    @PostMapping
    public void Adicionar(@RequestBody PermissaoPerfilRecursoDto perfilRecurso) {
        permissaoPerfilRecursoService.Adicionar(perfilRecurso);
    }
    @PutMapping
    public PermissaoPerfilRecursoDto AtualizarUsuario(@RequestBody PermissaoPerfilRecursoDto perfilRecurso) {
        return permissaoPerfilRecursoService.Atualizar(perfilRecurso);
    }
    @DeleteMapping
    public ResponseEntity<Void> deletar(@PathVariable("id") long id) {
        permissaoPerfilRecursoService.Deletar(id);
        return ResponseEntity.ok().build();
    }
}
