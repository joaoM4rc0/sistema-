package br.com.pessoal.projeto.service;

import br.com.pessoal.projeto.entity.UsuarioEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    private Long id;
    private String name;
    private String userName;
    private String email;
    private String passWord;

    public UserDetailsImpl(Long id, String name, String username, String password, String email,
                           Collection<? extends GrantedAuthority> authorities) {
        super();
        this.id = id;
        this.name = name;
        this.userName= username;
        this.passWord = password;
        this.email = email;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(UsuarioEntity usuario) {

        return new UserDetailsImpl(
                usuario.getId(),
                usuario.getName(),
                usuario.getLogin(),
                usuario.getSenha(),
                usuario.getEmail(),
                new ArrayList<>()
        );
    }
    private Collection<? extends GrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.passWord;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
