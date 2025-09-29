package br.com.pessoal.projeto.dto;

import br.com.pessoal.projeto.entity.PerfilEntity;
import br.com.pessoal.projeto.entity.PermissaoPerfilRecursoEntity;
import br.com.pessoal.projeto.entity.RecursoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class PermissaoPerfilRecursoDto {
    private Long id;
    private PerfilDto perfil;
    private RecursoDto recurso;

    public PermissaoPerfilRecursoDto(PermissaoPerfilRecursoEntity permissaoPerfilRecurso) {
        BeanUtils.copyProperties(permissaoPerfilRecurso, this);
        if(permissaoPerfilRecurso.getPerfil() != null) {
            this.perfil = new PerfilDto(permissaoPerfilRecurso.getPerfil());
        }
        if (permissaoPerfilRecurso.getRecurso() != null) {
            this.recurso = new RecursoDto(permissaoPerfilRecurso.getRecurso());
        }
    }
}
