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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private AlunoEntity aluno;

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

    @Column(nullable = false)
    private String situacao;

    public BoletimEntity(BoletimDTO boletim){
        BeanUtils.copyProperties(boletim, this);
        if(boletim != null && boletim.getAluno() != null){
            this.aluno = new AlunoEntity(boletim.getAluno());
        }
    }
}
