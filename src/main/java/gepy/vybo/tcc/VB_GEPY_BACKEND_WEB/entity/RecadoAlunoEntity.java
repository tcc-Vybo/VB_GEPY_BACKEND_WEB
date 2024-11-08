package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.RecadoAlunoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "recado_aluno")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class RecadoAlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", nullable = false)
    private FuncionarioEntity remetente;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private AlunoEntity destinatario;

    @NotBlank
    @Column(nullable = false)
    private String texto;

    @NotBlank
    @Column(nullable = false)
    private String data;

    private String hora;

    @NotBlank
    @Column(nullable = false)
    private String dataDeEnvio;

    @NotBlank
    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_tiporecado", nullable = false)
    private TipoRecadoEntity tipoRecado;

    @PrePersist
    @PreUpdate
    public void prePersistAndUpdate(){
        if (this.status != null){
            this.status = this.status.toUpperCase();
        }
    }

    public RecadoAlunoEntity(RecadoAlunoDTO recadoAluno){
        BeanUtils.copyProperties(recadoAluno, this);
        if(recadoAluno != null && recadoAluno.getRemetente() != null){
            this.remetente = new FuncionarioEntity(recadoAluno.getRemetente());
        }
        if(recadoAluno != null && recadoAluno.getDestinatario() != null){
            this.destinatario = new AlunoEntity(recadoAluno.getDestinatario());
        }
        if(recadoAluno != null && recadoAluno.getTipoRecado() != null){
            this.tipoRecado = new TipoRecadoEntity(recadoAluno.getTipoRecado());
        }
    }
}
