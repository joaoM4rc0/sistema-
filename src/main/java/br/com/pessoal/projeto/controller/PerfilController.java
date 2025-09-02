package br.com.pessoal.projeto.controller;

import br.com.pessoal.projeto.dto.PerfilDto;
import br.com.pessoal.projeto.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
@CrossOrigin
public class PerfilController {
    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public List<PerfilDto> ListarPerfil() {
        return perfilService.ListarPerfil();
    }

    @PostMapping
    public PerfilDto adicionarPerfil(@RequestBody PerfilDto perfil) {
        return perfilService.AdicionarPerfil(perfil);
    }
    @PutMapping
    public PerfilDto atualizarPerfil(@RequestBody PerfilDto perfil) {
        return perfilService.AtualizarPerfil(perfil);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeletarPerfil(@PathVariable("id") Long id) {
        perfilService.DeletarPerfil(id);
        return ResponseEntity.ok().build();
    }
}
