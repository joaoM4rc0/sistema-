package br.com.pessoal.projeto.dto;

import org.springframework.beans.BeanUtils;

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


}
