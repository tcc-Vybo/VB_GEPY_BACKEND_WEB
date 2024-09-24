package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.TurmaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.TurmaEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public List<TurmaDTO> listarTodos(){
        List<TurmaEntity> turma = turmaRepository.findAll();
        return turma.stream().map(TurmaDTO::new).toList();
    }

    public List<TurmaDTO> buscarPorNome(String nome){
        List<TurmaEntity> turmas = turmaRepository.findTurmaByName(nome);
        return turmas.stream().map(TurmaDTO::new).collect(Collectors.toList());
    }

    public void inserir(TurmaDTO turma){
        TurmaEntity turmaEntity = new TurmaEntity(turma);
        turmaRepository.save(turmaEntity);
    }

    public TurmaDTO alterar(TurmaDTO turma){
        TurmaEntity turmaEntity = new TurmaEntity(turma);
        return new TurmaDTO(turmaRepository.save(turmaEntity));
    }

    public void excluir(Long id){
        TurmaEntity turma = turmaRepository.findById(id).get();
        turmaRepository.delete(turma);
    }
}
