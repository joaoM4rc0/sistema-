package br.com.pessoal.projeto.dto;


import br.com.pessoal.projeto.entity.PerfilEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class PerfilDto {
    public PerfilDto(PerfilEntity perfilEntity) {
        BeanUtils.copyProperties(perfilEntity, this);
    }
}
