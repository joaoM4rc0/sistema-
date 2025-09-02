package br.com.pessoal.projeto.dto;

import org.springframework.beans.BeanUtils;

import br.com.pessoal.projeto.entity.Usuario;

public class UsuarioDto {
	private Long id; 
	private String name;
	private String login;
	private String email;
	private String senha;

	public UsuarioDto(Usuario usu) {
		BeanUtils.copyProperties(usu, this);
	}

	public UsuarioDto() {
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
	
	
	
}
