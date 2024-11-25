package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.BoletimDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "boletim")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class BoletimEntity extends BoletimDTO {

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

    public BoletimEntity(BoletimDTO boletim){
        BeanUtils.copyProperties(boletim, this);
        if(boletim != null && boletim.getAluno() != null){
            this.aluno = new AlunoEntity(boletim.getAluno());
        }
        if(boletim != null && boletim.getDisciplina() != null){
            this.disciplina = new DisciplinaEntity(boletim.getDisciplina());
        }
        if(boletim != null && boletim.getSituacao() != null){
            this.situacao = new SituacaoEntity(boletim.getSituacao());
        }
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public AlunoEntity getAluno() {
        return aluno;
    }

    public void setAluno(AlunoEntity aluno) {
        this.aluno = aluno;
    }

    @Override
    public DisciplinaEntity getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaEntity disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public int getNotaPrimeiroBim() {
        return notaPrimeiroBim;
    }

    @Override
    public void setNotaPrimeiroBim(int notaPrimeiroBim) {
        this.notaPrimeiroBim = notaPrimeiroBim;
    }

    @Override
    public int getFaltaPrimeiroBim() {
        return faltaPrimeiroBim;
    }

    @Override
    public void setFaltaPrimeiroBim(int faltaPrimeiroBim) {
        this.faltaPrimeiroBim = faltaPrimeiroBim;
    }

    @Override
    public int getNotaSegundoBim() {
        return notaSegundoBim;
    }

    @Override
    public void setNotaSegundoBim(int notaSegundoBim) {
        this.notaSegundoBim = notaSegundoBim;
    }

    @Override
    public int getFaltaSegundoBim() {
        return faltaSegundoBim;
    }

    @Override
    public void setFaltaSegundoBim(int faltaSegundoBim) {
        this.faltaSegundoBim = faltaSegundoBim;
    }

    @Override
    public int getNotaTerceiroBim() {
        return notaTerceiroBim;
    }

    @Override
    public void setNotaTerceiroBim(int notaTerceiroBim) {
        this.notaTerceiroBim = notaTerceiroBim;
    }

    @Override
    public int getFaltaTerceiroBim() {
        return faltaTerceiroBim;
    }

    @Override
    public void setFaltaTerceiroBim(int faltaTerceiroBim) {
        this.faltaTerceiroBim = faltaTerceiroBim;
    }

    @Override
    public int getNotaQuartoBim() {
        return notaQuartoBim;
    }

    @Override
    public void setNotaQuartoBim(int notaQuartoBim) {
        this.notaQuartoBim = notaQuartoBim;
    }

    @Override
    public int getFaltaQuartoBim() {
        return faltaQuartoBim;
    }

    @Override
    public void setFaltaQuartoBim(int faltaQuartoBim) {
        this.faltaQuartoBim = faltaQuartoBim;
    }

    @Override
    public SituacaoEntity getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoEntity situacao) {
        this.situacao = situacao;
    }
}
