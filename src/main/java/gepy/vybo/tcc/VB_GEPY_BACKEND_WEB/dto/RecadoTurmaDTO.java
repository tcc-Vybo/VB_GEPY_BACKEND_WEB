package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.RecadoTurmaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class RecadoTurmaDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private String data;
    private String hora;
    private String dataDeEnvio;
    private FuncionarioDTO remetente;
    private TurmaDTO destinatario;
    private String status;
    private TipoRecadoDTO tipoRecado;

    public RecadoTurmaDTO(RecadoTurmaEntity recadoTurma) {
        BeanUtils.copyProperties(recadoTurma, this);
        if(recadoTurma != null && recadoTurma.getRemetente() != null) {
            this.remetente = new FuncionarioDTO(recadoTurma.getRemetente());
        }
        if(recadoTurma != null && recadoTurma.getDestinatario() != null) {
            this.destinatario = new TurmaDTO(recadoTurma.getDestinatario());
        }
        if(recadoTurma != null && recadoTurma.getTipoRecado() != null) {
            this.tipoRecado = new TipoRecadoDTO(recadoTurma.getTipoRecado());
        }
    }
}
