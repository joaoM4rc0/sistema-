package br.com.pessoal.projeto.entity;

import br.com.pessoal.projeto.dto.PerfilUsuarioDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "JM_PERFIL_USUARIO")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PerfilUsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "ID_PERFIL")
    private PerfilEntity perfil;

    public PerfilUsuarioEntity(PerfilUsuarioDto perfilUsuario) {
        BeanUtils.copyProperties(perfilUsuario, this);
        if (perfilUsuario.getUsuario() != null) {
            this.usuario = new UsuarioEntity(perfilUsuario.getUsuario());
        }
        if (perfilUsuario.getPerfil() != null) {
            this.perfil = new PerfilEntity(perfilUsuario.getPerfil());
        }
    }

}
