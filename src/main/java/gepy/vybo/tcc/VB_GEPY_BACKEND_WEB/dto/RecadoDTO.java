package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.RecadoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class RecadoDTO {
    private Long id;
    private String rementente;
    private String destinatario;
    private String texto;
    private String dataAtual;
    private String horarioAtual;

    public RecadoDTO(RecadoEntity recado) {
        BeanUtils.copyProperties(recado, this);
    }
}