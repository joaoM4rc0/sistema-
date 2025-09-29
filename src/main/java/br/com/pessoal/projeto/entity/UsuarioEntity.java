package br.com.pessoal.projeto.entity;

import br.com.pessoal.projeto.Enum.TipoSituacaoUsu;
import br.com.pessoal.projeto.dto.UsuarioDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "JM_USUARIO")
public class UsuarioEntity {
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

    @Enumerated(EnumType.STRING)
    private TipoSituacaoUsu situacao;

    public UsuarioEntity(UsuarioDto usuario) {
        BeanUtils.copyProperties(usuario, this);
        this.situacao = TipoSituacaoUsu.ATIVO;
    }
    public UsuarioEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
