package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.BoletimDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "boletim")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class BoletimEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private AlunoEntity aluno;

    @ManyToOne
    @JoinColumn(name = "id_disciplina", nullable = false)
    private DisciplinaEntity disciplina;

    @Column(nullable = false)
    private int notaPrimeiroBim;

    @Column(nullable = false)
    private int faltaPrimeiroBim;

    @Column(nullable = false)
    private int notaSegundoBim;

    @Column(nullable = false)
    private int faltaSegundoBim;

    @Column(nullable = false)
    private int notaTerceiroBim;

    @Column(nullable = false)
    private int faltaTerceiroBim;

    @Column(nullable = false)
    private int notaQuartoBim;

    @Column(nullable = false)
    private int faltaQuartoBim;

    @ManyToOne
    @JoinColumn(name = "id_situacao", nullable = false)
    private SituacaoEntity situacao;

    public BoletimEntity(BoletimDTO boletim) {
        BeanUtils.copyProperties(boletim, this);
        if (boletim != null && boletim.getAluno() != null) {
            this.aluno = new AlunoEntity(boletim.getAluno());
        }
        if (boletim != null && boletim.getDisciplina() != null) {
            this.disciplina = new DisciplinaEntity(boletim.getDisciplina());
        }
        if (boletim != null && boletim.getSituacao() != null) {
            this.situacao = new SituacaoEntity(boletim.getSituacao());
        }
    }
}


