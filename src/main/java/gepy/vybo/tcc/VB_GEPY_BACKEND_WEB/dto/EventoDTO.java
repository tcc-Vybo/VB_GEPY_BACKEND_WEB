package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.EventoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.FuncionarioEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.TurmaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class EventoDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private String data;
    private String hora;
    private FuncionarioEntity remetente;
    private TurmaEntity destinatario;

    public EventoDTO(EventoEntity evento) {
        BeanUtils.copyProperties(evento, this);
    }
}
