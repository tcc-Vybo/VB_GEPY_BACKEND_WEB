package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.AlunoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.AlunoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoDTO buscarAlunoPorNome(String nomeCompleto){
        return alunoRepository.findAlunoByName(nomeCompleto);
    }

    public List<AlunoDTO> ListarTodos(){
        List<AlunoEntity> aluno = alunoRepository.findAll();
        return aluno.stream().map(AlunoDTO::new).toList();
    }


    public void inserir(AlunoDTO aluno) {
        AlunoEntity alunoEntity = new AlunoEntity(aluno);
        alunoRepository.save(alunoEntity);
    }

    public AlunoDTO alterar(AlunoDTO aluno) {
        AlunoEntity alunoEntity = new AlunoEntity(aluno);
        return new AlunoDTO(alunoRepository.save(alunoEntity));
    }

        public void excluir (Long id){
            AlunoEntity aluno = alunoRepository.findById(id).get();
            alunoRepository.delete(aluno);
        }


        public AlunoDTO buscarPorId(Long id){
        return new AlunoDTO(alunoRepository.findById(id).get());
        }


};