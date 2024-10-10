package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.DisciplinaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class DisciplinaDTO {

    private Long id;
    private String nome;
    private String descricao;

    public DisciplinaDTO(DisciplinaEntity disciplina){
        BeanUtils.copyProperties(disciplina, this);
    }
}
