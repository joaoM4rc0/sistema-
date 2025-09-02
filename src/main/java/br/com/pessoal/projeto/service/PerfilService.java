package br.com.pessoal.projeto.service;

import br.com.pessoal.projeto.dto.PerfilDto;
import br.com.pessoal.projeto.entity.PerfilEntity;
import br.com.pessoal.projeto.entity.RecursoEntity;
import br.com.pessoal.projeto.repository.PerfilRepository;
import br.com.pessoal.projeto.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PerfilService {
    @Autowired
    private PerfilRepository perfilRepository;

    public List<PerfilDto> ListarPerfil() {
        List<PerfilEntity> perfil = perfilRepository.findAll();
        return perfil.stream().map(PerfilDto::new).toList();
    }
    public PerfilDto AdicionarPerfil(PerfilDto perfil)  {
        PerfilEntity perfilDto = perfilRepository.save(new PerfilEntity(perfil));
        return new PerfilDto(perfilDto);
    }
    public PerfilDto AtualizarPerfil(PerfilDto perfil) {
        return new PerfilDto(perfilRepository.save(new PerfilEntity(perfil)));
    }
    public void DeletarPerfil(Long id) {
        if (perfilRepository.existsById(id)) {
            perfilRepository.deleteById(id);
        }else {
            throw new IllegalArgumentException("esse recurso nao existe");
        }
    }
    public PerfilDto ProcurarPorId(Long id ) {
        return new PerfilDto(perfilRepository.findById(id).orElseThrow(() -> new RuntimeException("esse recurso nao existe")));
    }
}
