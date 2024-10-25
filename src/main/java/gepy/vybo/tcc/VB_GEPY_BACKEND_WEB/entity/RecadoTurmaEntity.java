package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.RecadoTurmaDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "recado_turma")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class RecadoTurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String data;

    @Column(nullable = false)
    private String hora;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", nullable = false)
    private FuncionarioEntity remetente;

    @ManyToOne
    @JoinColumn(name = "id_turma", nullable = false)
    private TurmaEntity destinatario;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String tipoRecado;

    public RecadoTurmaEntity(RecadoTurmaDTO recadoTurma){
        BeanUtils.copyProperties(recadoTurma, this);
        if(recadoTurma != null && recadoTurma.getRemetente() != null){
            this.remetente = new FuncionarioEntity(recadoTurma.getRemetente());
        }
        if(recadoTurma != null && recadoTurma.getDestinatario() != null){
            this.destinatario = new TurmaEntity(recadoTurma.getDestinatario());
        }
    }
}
