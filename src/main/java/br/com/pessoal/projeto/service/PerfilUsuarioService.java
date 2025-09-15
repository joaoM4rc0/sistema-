package br.com.pessoal.projeto.service;

import br.com.pessoal.projeto.dto.PerfilDto;
import br.com.pessoal.projeto.dto.PerfilUsuarioDto;
import br.com.pessoal.projeto.entity.PerfilEntity;
import br.com.pessoal.projeto.entity.PerfilUsuarioEntity;
import br.com.pessoal.projeto.repository.PerfilUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilUsuarioService {
    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;

    public List<PerfilUsuarioDto> Listar() {
        List<PerfilUsuarioEntity> perfilUsuario = perfilUsuarioRepository.findAll();
        return perfilUsuario.stream().map(PerfilUsuarioDto::new).toList();
    }
    public PerfilUsuarioDto Adicionar(PerfilUsuarioDto perfilUsuario)  {
        PerfilUsuarioEntity perfilEntity = perfilUsuarioRepository.save(new PerfilUsuarioEntity(perfilUsuario));
        return new PerfilUsuarioDto(perfilEntity);
    }
    public PerfilUsuarioDto Atualizar(PerfilUsuarioDto perfil) {
        return new PerfilUsuarioDto(perfilUsuarioRepository.save(new PerfilUsuarioEntity(perfil)));
    }
    public void Deletar(Long id) {
        if (perfilUsuarioRepository.existsById(id)) {
            perfilUsuarioRepository.deleteById(id);
        }else {
            throw new IllegalArgumentException("esse recurso nao existe");
        }
    }
    public PerfilUsuarioDto ProcurarPorId(Long id ) {
        return new PerfilUsuarioDto(perfilUsuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("esse recurso nao existe")));
    }
}
