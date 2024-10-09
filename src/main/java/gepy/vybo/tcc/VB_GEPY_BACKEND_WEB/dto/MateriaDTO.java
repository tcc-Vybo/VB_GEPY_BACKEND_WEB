package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.MateriaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class MateriaDTO {

    private Long id;
    private String nome;
    private String descricao;

    public MateriaDTO(MateriaEntity materia){
        BeanUtils.copyProperties(materia, this);
    }
}
