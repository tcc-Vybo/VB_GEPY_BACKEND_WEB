package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.RecadoTurmaDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    @Column(nullable = false)
    private String titulo;

    @NotBlank
    @Column(nullable = false)
    private String descricao;

    @NotBlank
    @Column(nullable = false)
    private String data;

    private String hora;

    @NotBlank
    @Column(nullable = false)
    private String dataDeEnvio;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", nullable = false)
    private FuncionarioEntity remetente;

    @ManyToOne
    @JoinColumn(name = "id_turma", nullable = false)
    private TurmaEntity destinatario;

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

    public RecadoTurmaEntity(RecadoTurmaDTO recadoTurma){
        BeanUtils.copyProperties(recadoTurma, this);
        if(recadoTurma != null && recadoTurma.getRemetente() != null){
            this.remetente = new FuncionarioEntity(recadoTurma.getRemetente());
        }
        if(recadoTurma != null && recadoTurma.getDestinatario() != null){
            this.destinatario = new TurmaEntity(recadoTurma.getDestinatario());
        }
        if(recadoTurma != null && recadoTurma.getTipoRecado() != null){
            this.tipoRecado = new TipoRecadoEntity(recadoTurma.getTipoRecado());
        }
    }
}
