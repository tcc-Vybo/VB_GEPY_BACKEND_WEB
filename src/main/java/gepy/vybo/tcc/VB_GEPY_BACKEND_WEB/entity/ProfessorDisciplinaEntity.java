package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.ProfessorDisciplinaDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "professor_disciplina", uniqueConstraints = @UniqueConstraint(columnNames = {"id_professor", "id_disciplina"}))
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProfessorDisciplinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_professor", nullable = false)
    private FuncionarioEntity professor;

    @ManyToOne
    @JoinColumn(name = "id_disciplina", nullable = false)
    private DisciplinaEntity disciplina;

    public ProfessorDisciplinaEntity(ProfessorDisciplinaDTO professorDisciplina) {
        BeanUtils.copyProperties(professorDisciplina, this);
        if(professorDisciplina != null && professorDisciplina.getProfessor() != null) {
            this.professor = new FuncionarioEntity(professorDisciplina.getProfessor());
        }
        if(professorDisciplina != null && professorDisciplina.getDisciplina() != null) {
            this.disciplina = new DisciplinaEntity(professorDisciplina.getDisciplina());
        }
    }
}
