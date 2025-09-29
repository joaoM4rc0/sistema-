package br.com.pessoal.projeto.service;

import br.com.pessoal.projeto.entity.UsuarioEntity;
import br.com.pessoal.projeto.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity user = usuarioRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("usuario nao existe"));
        return UserDetailsImpl.build(user);
    }
}
