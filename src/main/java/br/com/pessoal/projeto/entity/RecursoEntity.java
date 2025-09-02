package br.com.pessoal.projeto.entity;


import br.com.pessoal.projeto.dto.RecursoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "JM_recurso")
public class RecursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String chave;

    public RecursoEntity(RecursoDto recursoDto) {
        BeanUtils.copyProperties(recursoDto, this);
    }

    public RecursoEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RecursoEntity that = (RecursoEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
