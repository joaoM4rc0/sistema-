package br.com.pessoal.projeto.dto;


import br.com.pessoal.projeto.entity.RecursoEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
public class RecursoDto {
    private Long id;
    private String nome;
    private String chave;

    public RecursoDto(RecursoEntity recurso) {
        BeanUtils.copyProperties(recurso, this);
    }

    public RecursoDto() {
    }

}
