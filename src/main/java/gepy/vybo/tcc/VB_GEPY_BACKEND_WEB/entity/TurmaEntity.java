package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.TurmaDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "turma")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String materia;

    @ManyToOne
    @JoinColumn(name = "id_professor", nullable = false)
    private FuncionarioEntity professor;

    public TurmaEntity(TurmaDTO turma) {
        BeanUtils.copyProperties(turma, this);
        if(turma != null && turma.getProfessor() != null) {
            this.professor = new FuncionarioEntity(turma.getProfessor());
        }
    }
}
