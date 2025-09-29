package br.com.pessoal.projeto.dto;

import br.com.pessoal.projeto.Enum.TipoSituacaoUsu;
import br.com.pessoal.projeto.entity.UsuarioEntity;
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
	private TipoSituacaoUsu situacao;
	public UsuarioDto(UsuarioEntity usu) {
		BeanUtils.copyProperties(usu, this);
	}

	public UsuarioDto() {
	}


}
