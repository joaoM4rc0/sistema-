package br.com.pessoal.projeto.entity;



import br.com.pessoal.projeto.dto.PerfilDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table(name = "JM_PERFIL")
@Getter
@Setter
@NoArgsConstructor
public class PerfilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( nullable = false)
    private String descricao;

    public PerfilEntity(PerfilDto perfilDto) {
        BeanUtils.copyProperties(perfilDto, this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PerfilEntity that = (PerfilEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
