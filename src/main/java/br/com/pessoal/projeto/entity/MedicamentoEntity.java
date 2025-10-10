package br.com.pessoal.projeto.entity;

import br.com.pessoal.projeto.dto.MedicamentoDto;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MedicamentoEntity {
    private long id;
    private String nome;
    private String descricao;
    private double preco;
    private String quantidadeEstoque;
    private LocalDate dataValidade;
    private String fabricante;

    public MedicamentoEntity(MedicamentoDto medicamentoDto) {
        BeanUtils.copyProperties(medicamentoDto, this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MedicamentoEntity that = (MedicamentoEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
