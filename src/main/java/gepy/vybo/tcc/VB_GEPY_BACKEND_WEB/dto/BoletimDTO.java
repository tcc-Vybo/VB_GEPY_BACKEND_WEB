package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.BoletimEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class BoletimDTO {

    private Long id;
    private AlunoDTO aluno;
    private DisciplinaDTO disciplina;
    private int notaPrimeiroBim;
    private int faltaPrimeiroBim;
    private int notaSegundoBim;
    private int faltaSegundoBim;
    private int notaTerceiroBim;
    private int faltaTerceiroBim;
    private int notaQuartoBim;
    private int faltaQuartoBim;
    private SituacaoDTO situacao;

    public BoletimDTO(BoletimEntity boletim){
        BeanUtils.copyProperties(boletim, this);
        if(boletim != null && boletim.getAluno() != null){
            this.aluno = new AlunoDTO(boletim.getAluno());
        }
        if(boletim != null && boletim.getDisciplina() != null){
            this.disciplina = new DisciplinaDTO(boletim.getDisciplina());
        }
        if(boletim != null && boletim.getSituacao() != null){
            this.situacao = new SituacaoDTO(boletim.getSituacao());
        }
    }
}
