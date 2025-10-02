package br.com.pessoal.projeto.service;

import br.com.pessoal.projeto.Enum.TipoSituacaoUsu;
import br.com.pessoal.projeto.dto.UsuarioDto;
import br.com.pessoal.projeto.entity.UsuarioEntity;
import br.com.pessoal.projeto.entity.UsuarioVerificadorEntity;
import br.com.pessoal.projeto.repository.UsuarioRepository;
import br.com.pessoal.projeto.repository.UsuarioVerificadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioVerificadorRepository usuarioVerificadorRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailService emailService;
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

        UsuarioVerificadorEntity verificador = new UsuarioVerificadorEntity();
        verificador.setUsuario(usuarioEntity);
        verificador.setUuid(UUID.randomUUID());
        verificador.setDataExpiracao(Instant.now().plusMillis(900000));

        usuarioVerificadorRepository.save(verificador);
        emailService.enviarEmailTexto(usuario.getEmail(), "novo usuario cadastrado", "vc está recebendo um email de cadastro, o numero para verificação é : " + verificador.getUuid());

    }
    public String verificarUsuario(String uuid) {
        UsuarioVerificadorEntity verificador = usuarioVerificadorRepository.findByUuid(UUID.fromString(uuid)).get();
        if (usuarioVerificadorRepository == null) {
            return "usuario nao existe";
        }
        if (verificador.getDataExpiracao().isBefore(Instant.now())) {
            usuarioVerificadorRepository.deleteById(verificador.getId());
            return "tempo de verificação expirado";
        }
        UsuarioEntity usuario = verificador.getUsuario();
        usuario.setSituacao(TipoSituacaoUsu.ATIVO);
        usuarioRepository.save(usuario);
    return "usuario verificado";
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
