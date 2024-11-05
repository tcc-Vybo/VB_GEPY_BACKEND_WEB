package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.BoletimDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private AlunoEntity aluno;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "id_disciplina", nullable = false)
    private DisciplinaEntity disciplina;

    @NotBlank
    @Column(nullable = false)
    private int notaPrimeiroBim;

    @NotBlank
    @Column(nullable = false)
    private int faltaPrimeiroBim;

    @NotBlank
    @Column(nullable = false)
    private int notaSegundoBim;

    @NotBlank
    @Column(nullable = false)
    private int faltaSegundoBim;

    @NotBlank
    @Column(nullable = false)
    private int notaTerceiroBim;

    @NotBlank
    @Column(nullable = false)
    private int faltaTerceiroBim;

    @NotBlank
    @Column(nullable = false)
    private int notaQuartoBim;

    @NotBlank
    @Column(nullable = false)
    private int faltaQuartoBim;

    @NotBlank
    @Column(nullable = false)
    private String situacao;

    public BoletimEntity(BoletimDTO boletim){
        BeanUtils.copyProperties(boletim, this);
        if(boletim != null && boletim.getAluno() != null){
            this.aluno = new AlunoEntity(boletim.getAluno());
        }
        if(boletim != null && boletim.getDisciplina() != null){
            this.disciplina = new DisciplinaEntity(boletim.getDisciplina());
        }
    }
}
