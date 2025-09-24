package br.com.pessoal.projeto.service;

import br.com.pessoal.projeto.entity.Usuario;
import br.com.pessoal.projeto.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements UserDetails {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByUserLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("usuario nao existe"));
        return UserDetailsImpl.build(user);
    }
}
