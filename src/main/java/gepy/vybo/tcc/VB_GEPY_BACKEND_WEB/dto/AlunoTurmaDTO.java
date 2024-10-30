package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.AlunoTurmaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class AlunoTurmaDTO {

    private Long id;
    private AlunoDTO aluno;
    private TurmaDTO turma;

    public AlunoTurmaDTO(AlunoTurmaEntity alunoTurma){
        BeanUtils.copyProperties(alunoTurma, this);
        if(alunoTurma != null && alunoTurma.getAluno() != null){
            this.aluno = new AlunoDTO(alunoTurma.getAluno());
        }
        if(alunoTurma != null && alunoTurma.getTurma() != null){
            this.turma = new TurmaDTO(alunoTurma.getTurma());
        }
    }

}
