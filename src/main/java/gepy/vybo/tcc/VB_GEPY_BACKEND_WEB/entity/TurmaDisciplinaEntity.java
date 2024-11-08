package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.TurmaDisciplinaDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "turma_disciplina")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TurmaDisciplinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_turma", nullable = false)
    private TurmaEntity turma;

    @ManyToOne
    @JoinColumn(name = "id_disciplina", nullable = false)
    private DisciplinaEntity disciplina;

    public TurmaDisciplinaEntity(TurmaDisciplinaDTO turmaDisciplina){
        BeanUtils.copyProperties(turmaDisciplina, this);
        if(turmaDisciplina != null && turmaDisciplina.getTurma() != null){
            this.turma = new TurmaEntity(turmaDisciplina.getTurma());
        }
        if(turmaDisciplina != null && turmaDisciplina.getDisciplina() != null){
            this.disciplina  = new DisciplinaEntity(turmaDisciplina.getDisciplina());
        }
    }
}
