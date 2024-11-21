package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.DisciplinaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.DisciplinaEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<DisciplinaDTO> listarTodos(){
        List<DisciplinaEntity> disciplinas = disciplinaRepository.findAllOrderedById();
        return disciplinas.stream().map(DisciplinaDTO::new).toList();
    }

    public List<DisciplinaDTO> buscarPorNome(String nome){
        List<DisciplinaEntity> disciplinas = disciplinaRepository.findDisciplinaByNome(nome);
        return disciplinas.stream().map(DisciplinaDTO::new).collect(Collectors.toList());
    }

    public ResponseEntity<Map<String, String>> inserir(DisciplinaDTO disciplina){
        DisciplinaEntity disciplinaEntity = new DisciplinaEntity(disciplina);
        Map<String, String> response = new HashMap<>();
        try {
            disciplinaRepository.save(disciplinaEntity);
            response.put("message", "Disciplina registrada com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao inserir disciplina!!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterar(DisciplinaDTO disciplina){
        DisciplinaEntity disciplinaEntity = new DisciplinaEntity(disciplina);
        Map<String, String> response = new HashMap<>();
        try{
            disciplinaRepository.save(disciplinaEntity);
            response.put("message", "Disciplina alterada com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao alterar disciplina!!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir(Long id){
        DisciplinaEntity disciplinaEntity = disciplinaRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try {
            disciplinaRepository.delete(disciplinaEntity);
            response.put("message", "Disciplina removida com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao remover disciplina!!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
