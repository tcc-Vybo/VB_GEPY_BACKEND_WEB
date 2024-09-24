package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.FuncionarioDTO;
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

    @ManyToOne
    private FuncionarioEntity professor;

    @ManyToOne
    private AlunoEntity aluno;

    public TurmaEntity(TurmaDTO turma) {
        BeanUtils.copyProperties(turma, this);
        if(turma != null && turma.getAluno() != null) {
            this.aluno = new AlunoEntity(turma.getAluno());
        }
        if(turma != null && turma.getProfessor() != null) {
            this.professor = new FuncionarioEntity(turma.getProfessor());
        }
    }
}
