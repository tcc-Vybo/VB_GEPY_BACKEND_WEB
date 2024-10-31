package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.TurmaDisciplinaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class TurmaDisciplinaDTO {

    private Long id;
    private TurmaDTO turma;
    private DisciplinaDTO disciplina;

    public TurmaDisciplinaDTO(TurmaDisciplinaEntity turmaDisciplina) {
        BeanUtils.copyProperties(turmaDisciplina, this);
        if(turmaDisciplina != null && turmaDisciplina.getTurma() != null) {
            this.turma = new TurmaDTO(turmaDisciplina.getTurma());
        }
        if(turmaDisciplina != null && turmaDisciplina.getDisciplina() != null) {
            this.disciplina  = new DisciplinaDTO(turmaDisciplina.getDisciplina());
        }
    }
}
