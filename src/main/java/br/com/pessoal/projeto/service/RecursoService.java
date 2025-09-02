package br.com.pessoal.projeto.service;

import br.com.pessoal.projeto.dto.RecursoDto;
import br.com.pessoal.projeto.entity.RecursoEntity;
import br.com.pessoal.projeto.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecursoService {
    @Autowired
    private RecursoRepository recursoRepository;

    public List<RecursoDto> ListarRecursos() {
        List<RecursoEntity> recursos = recursoRepository.findAll();
        return recursos.stream().map(RecursoDto::new).toList();
    }
    public RecursoDto AdicionarRecurso(RecursoDto recurso)  {
        RecursoEntity recursoEntity = recursoRepository.save(new RecursoEntity(recurso));
        return new RecursoDto(recursoEntity);
    }
    public RecursoDto AtualizarRecurso(RecursoDto recursoDto) {
        return new RecursoDto(recursoRepository.save(new RecursoEntity(recursoDto)));
    }
    public void DeletarRecurso(Long id) {
        if (recursoRepository.existsById(id)) {
            recursoRepository.deleteById(id);
        }else {
            throw new IllegalArgumentException("esse recurso nao existe");
        }
    }
    public RecursoDto ProcurarPorId(Long id ) {
        return new RecursoDto(recursoRepository.findById(id).orElseThrow(() -> new RuntimeException("esse recurso nao existe")));
    }
}
