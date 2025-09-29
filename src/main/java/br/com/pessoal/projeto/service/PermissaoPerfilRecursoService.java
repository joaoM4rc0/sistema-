package br.com.pessoal.projeto.service;

import br.com.pessoal.projeto.dto.PermissaoPerfilRecursoDto;
import br.com.pessoal.projeto.entity.PermissaoPerfilRecursoEntity;
import br.com.pessoal.projeto.repository.PerfilUsuarioRepository;
import br.com.pessoal.projeto.repository.PermissaoPerfilRecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoPerfilRecursoService {
    @Autowired
    private PermissaoPerfilRecursoRepository permissaoPerfilRecursoRepository;

    public List<PermissaoPerfilRecursoDto> Listar() {
        List<PermissaoPerfilRecursoEntity> perfilRecurso = permissaoPerfilRecursoRepository.findAll();
        return perfilRecurso.stream().map(PermissaoPerfilRecursoDto::new).toList();
    }
    public PermissaoPerfilRecursoDto Adicionar(PermissaoPerfilRecursoDto perfilUsuario)  {
        PermissaoPerfilRecursoEntity permissaoPerfilRecurso = permissaoPerfilRecursoRepository.save(new PermissaoPerfilRecursoEntity(perfilUsuario));
        return new PermissaoPerfilRecursoDto(permissaoPerfilRecurso);
    }
    public PermissaoPerfilRecursoDto Atualizar(PermissaoPerfilRecursoDto perfil) {
        return new PermissaoPerfilRecursoDto(permissaoPerfilRecursoRepository.save(new PermissaoPerfilRecursoEntity(perfil)));
    }
    public void Deletar(Long id) {
        if (permissaoPerfilRecursoRepository.existsById(id)) {
            permissaoPerfilRecursoRepository.deleteById(id);
        }else {
            throw new IllegalArgumentException("esse recurso nao existe");
        }
    }
    public PermissaoPerfilRecursoDto ProcurarPorId(Long id ) {
        return new PermissaoPerfilRecursoDto(permissaoPerfilRecursoRepository.findById(id).orElseThrow(() -> new RuntimeException("esse recurso nao existe")));
    }
}
