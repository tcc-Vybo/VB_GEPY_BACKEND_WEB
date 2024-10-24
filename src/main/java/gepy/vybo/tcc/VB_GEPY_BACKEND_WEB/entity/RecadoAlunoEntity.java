package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.RecadoAlunoDTO;
import jakarta.persistence.*;
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
    @JoinColumn(name = "id_aluno",nullable = false)
    private AlunoEntity destinatario;

    @Column(nullable = false)
    private String texto;

    @Column(nullable = false)
    private String dataAtual;

    @Column(nullable = false)
    private String horarioAtual;

    @Column(nullable = false)
    private String status;

    public RecadoAlunoEntity(RecadoAlunoDTO recadoAluno){
        BeanUtils.copyProperties(recadoAluno, this);
        if(recadoAluno != null && recadoAluno.getRemetente() != null){
            this.remetente = new FuncionarioEntity(recadoAluno.getRemetente());
        }
        if(recadoAluno != null && recadoAluno.getDestinatario() != null){
            this.destinatario = new AlunoEntity(recadoAluno.getDestinatario());
        }
    }
}
