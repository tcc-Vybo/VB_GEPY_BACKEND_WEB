package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.AlunoTurmaDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "aluno_turma", uniqueConstraints = @UniqueConstraint(columnNames = {"id_aluno", "id_turma"}))
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class AlunoTurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private AlunoEntity aluno;

    @ManyToOne
    @JoinColumn(name = "id_turma", nullable = false)
    private TurmaEntity turma;

    public AlunoTurmaEntity(AlunoTurmaDTO alunoTurma){
        BeanUtils.copyProperties(alunoTurma, this);
        if(alunoTurma != null && alunoTurma.getAluno() != null){
            this.aluno = new AlunoEntity(alunoTurma.getAluno());
        }
        if(alunoTurma != null && alunoTurma.getTurma() != null){
            this.turma = new TurmaEntity(alunoTurma.getTurma());
        }
    }
}
