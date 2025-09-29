package br.com.pessoal.projeto.service;

import br.com.pessoal.projeto.dto.UsuarioDto;
import br.com.pessoal.projeto.entity.UsuarioEntity;
import br.com.pessoal.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDto> ListarTodos() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDto::new).toList();
    }
    public UsuarioDto InserirUsuario(UsuarioDto usuarioDto) {
        UsuarioEntity usuario = usuarioRepository.save(new UsuarioEntity(usuarioDto));
        return new UsuarioDto(usuario);
    }
    public UsuarioDto AtualizarUsuario(UsuarioDto usuarioDto) {
        return new UsuarioDto(usuarioRepository.save(new UsuarioEntity(usuarioDto)));
    }
    public void DeletarUsuario(long id){
        boolean exist = usuarioRepository.existsById(id);
        if (exist) {
            usuarioRepository.deleteById(id);
        }else {
            throw new RuntimeException("esse usuario nao existe");
        }
    }
    public UsuarioDto BuscarPorId(long id){
        return new UsuarioDto(usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("esse usuario nao existe")));
    }
}
