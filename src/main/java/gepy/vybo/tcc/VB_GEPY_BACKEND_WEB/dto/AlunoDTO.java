package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.AlunoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class AlunoDTO {

    private Long id;

    public AlunoDTO(AlunoEntity aluno) {
        BeanUtils.copyProperties(aluno, this);
    }
}
