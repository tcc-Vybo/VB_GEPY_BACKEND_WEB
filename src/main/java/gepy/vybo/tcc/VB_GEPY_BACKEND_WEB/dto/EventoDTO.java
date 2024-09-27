package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.EventoEntity;
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
    private FuncionarioDTO remetente;
    private TurmaDTO destinatario;

    public EventoDTO(EventoEntity evento) {
        BeanUtils.copyProperties(evento, this);
        if(evento != null && evento.getRemetente() != null) {
            this.remetente = new FuncionarioDTO(evento.getRemetente());
        }
        if(evento != null && evento.getDestinatario() != null) {
            this.destinatario = new TurmaDTO(evento.getDestinatario());
        }
    }
}
