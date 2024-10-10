package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.RecadoAlunoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class RecadoAlunoDTO {
    private Long id;
    private FuncionarioDTO remetente;
    private AlunoDTO destinatario;
    private String texto;
    private String dataAtual;
    private String horarioAtual;
    private String status;

    public RecadoAlunoDTO(RecadoAlunoEntity recadoAluno) {
        BeanUtils.copyProperties(recadoAluno, this);
        if(recadoAluno != null && recadoAluno.getRemetente() != null){
            this.remetente = new FuncionarioDTO(recadoAluno.getRemetente());
        }
        if(recadoAluno != null && recadoAluno.getDestinatario() != null){
            this.destinatario = new AlunoDTO(recadoAluno.getDestinatario());
        }
    }
}
