package br.com.pessoal.projeto.dto;

import br.com.pessoal.projeto.entity.PerfilEntity;
import br.com.pessoal.projeto.entity.PerfilUsuarioEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
@Getter
@Setter
@NoArgsConstructor
public class PerfilUsuarioDto {
    private Long id;
    private UsuarioDto usuario;
    private PerfilDto perfil;

    public PerfilUsuarioDto(PerfilUsuarioEntity perfilUsuario) {
        BeanUtils.copyProperties(perfilUsuario, this);
        if(perfilUsuario.getUsuario() != null) {
            this.usuario = new UsuarioDto(perfilUsuario.getUsuario());
        }
        if (perfilUsuario.getPerfil() != null) {
            this.perfil = new PerfilDto(perfilUsuario.getPerfil());
        }
    }
}
