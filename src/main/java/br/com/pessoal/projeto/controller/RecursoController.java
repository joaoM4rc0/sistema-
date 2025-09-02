package br.com.pessoal.projeto.controller;

import br.com.pessoal.projeto.dto.RecursoDto;
import br.com.pessoal.projeto.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recursos")
@CrossOrigin
public class RecursoController {
    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public List<RecursoDto> ListarRecursos() {
        return recursoService.ListarRecursos();
    }

    @PostMapping
    public RecursoDto adicionarRecurso(@RequestBody RecursoDto recurso) {
        return recursoService.AdicionarRecurso(recurso);
    }
    @PutMapping
    public RecursoDto atualizarRecurso(@RequestBody RecursoDto recurso) {
        return recursoService.AtualizarRecurso(recurso);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeletarRecurso(@PathVariable("id") Long id) {
        recursoService.DeletarRecurso(id);
        return ResponseEntity.ok().build();
    }
}
