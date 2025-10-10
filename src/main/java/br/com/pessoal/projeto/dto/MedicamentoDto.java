package br.com.pessoal.projeto.dto;

import br.com.pessoal.projeto.entity.MedicamentoEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Getter
@Setter

public class MedicamentoDto {
    private long id;
    private String nome;
    private String descricao;
    private double preco;
    private String quantidadeEstoque;
    private LocalDate dataValidade;
    private String fabricante;

    public MedicamentoDto(MedicamentoEntity medicamento) {
        BeanUtils.copyProperties(medicamento, this);
    }

    public MedicamentoDto() {
    }
}
