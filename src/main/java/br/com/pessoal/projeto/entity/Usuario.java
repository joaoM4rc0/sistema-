package br.com.pessoal.projeto.entity;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import br.com.pessoal.projeto.dto.UsuarioDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "JM_USUARIO")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String login;
	@Column(nullable = false)
	private String senha; 
	@Column(nullable = false)
	private String email;
	public Usuario(UsuarioDto usuario) {
		BeanUtils.copyProperties(usuario, this);
	}
	
	public Usuario() {
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	} 
	
	
}
