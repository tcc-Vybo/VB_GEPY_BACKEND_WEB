package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.TipoRecadoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class TipoRecadoDTO {

    private Long id;
    private String nome;

    public TipoRecadoDTO(TipoRecadoEntity tipoRecado) {
        BeanUtils.copyProperties(tipoRecado, this);
    }
}
