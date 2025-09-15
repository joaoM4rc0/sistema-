package br.com.pessoal.projeto.dto;

import br.com.pessoal.projeto.entity.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
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
