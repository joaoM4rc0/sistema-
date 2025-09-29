package br.com.pessoal.projeto.entity;

import br.com.pessoal.projeto.dto.PerfilDto;
import br.com.pessoal.projeto.dto.PermissaoPerfilRecursoDto;
import br.com.pessoal.projeto.dto.RecursoDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Getter
@Setter
@Table(name = "JM_PERMISSAO-PERFIL-RECURSO")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PermissaoPerfilRecursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ID_PERFIL")
    private PerfilEntity perfil;
    @ManyToOne
    @JoinColumn(name = "ID_RECURSO")
    private RecursoEntity recurso;

    public PermissaoPerfilRecursoEntity(PermissaoPerfilRecursoDto permissaoPerfilRecurso) {
        BeanUtils.copyProperties(permissaoPerfilRecurso, this);
        if(permissaoPerfilRecurso.getPerfil() != null) {
            this.perfil = new PerfilEntity(permissaoPerfilRecurso.getPerfil());
        }
        if (permissaoPerfilRecurso.getRecurso() != null) {
            this.recurso = new RecursoEntity(permissaoPerfilRecurso.getRecurso());
        }
    }
}
