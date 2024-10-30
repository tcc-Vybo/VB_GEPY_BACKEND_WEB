package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.ProfessorDisciplinaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class ProfessorDisciplinaDTO {

    private Long id;
    private FuncionarioDTO professor;
    private DisciplinaDTO disciplina;

    public ProfessorDisciplinaDTO(ProfessorDisciplinaEntity professorDisciplina) {
        BeanUtils.copyProperties(professorDisciplina, this);
        if(professorDisciplina != null && professorDisciplina.getProfessor() != null) {
            this.professor  = new FuncionarioDTO(professorDisciplina.getProfessor());
        }
        if(professorDisciplina != null && professorDisciplina.getDisciplina() != null) {
            this.disciplina = new DisciplinaDTO(professorDisciplina.getDisciplina());
        }
    }
}
