package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.SituacaoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class SituacaoDTO {

    private Long id;
    private String nome;

    public SituacaoDTO(SituacaoEntity situacao) {
        BeanUtils.copyProperties(situacao, this);
    }
}
