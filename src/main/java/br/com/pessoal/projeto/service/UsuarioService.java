package br.com.pessoal.projeto.service;

import br.com.pessoal.projeto.Enum.TipoSituacaoUsu;
import br.com.pessoal.projeto.dto.UsuarioDto;
import br.com.pessoal.projeto.entity.UsuarioEntity;
import br.com.pessoal.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public List<UsuarioDto> ListarTodos() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDto::new).toList();
    }
    public void InserirUsuario(UsuarioDto usuarioDto) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDto);
        usuarioEntity.setSenha(passwordEncoder.encode(usuarioEntity.getSenha()));
        usuarioRepository.save(usuarioEntity);
    }
    public void InserirNovoUsuario (UsuarioDto usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioEntity.setSenha(passwordEncoder.encode(usuarioEntity.getSenha()));
        usuarioEntity.setSituacao(TipoSituacaoUsu.PENDENTE);
        usuarioEntity.setId(null);
        usuarioRepository.save(usuarioEntity);
    }
    public UsuarioDto AtualizarUsuario(UsuarioDto usuarioDto) {
        UsuarioEntity usuario = usuarioRepository.save(new UsuarioEntity(usuarioDto));
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return new UsuarioDto(usuarioRepository.save(usuario));
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
