package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.TurmaDisciplinaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.TurmaDisciplinaEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.TurmaDisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TurmaDisciplinaService {

    @Autowired
    private TurmaDisciplinaRepository turmaDisciplinaRepository;

    public List<TurmaDisciplinaDTO> listarTodos(){
        List<TurmaDisciplinaEntity> turmaDisciplina = turmaDisciplinaRepository.findAllOrderedById();
        return turmaDisciplina.stream().map(TurmaDisciplinaDTO::new).toList();
    }

    public ResponseEntity<Map<String, String>> inserir(TurmaDisciplinaDTO turmaDisciplina){
        TurmaDisciplinaEntity turmaDisciplinaEntity = new TurmaDisciplinaEntity(turmaDisciplina);
        Map<String, String> response = new HashMap<>();
        try{
            turmaDisciplinaRepository.save(turmaDisciplinaEntity);
            response.put("message", "Turma associada a disciplina com sucesso!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao associar turma!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterar(TurmaDisciplinaDTO turmaDisciplina){
        TurmaDisciplinaEntity turmaDisciplinaEntity = new TurmaDisciplinaEntity(turmaDisciplina);
        Map<String, String> response = new HashMap<>();
        try{
            turmaDisciplinaRepository.save(turmaDisciplinaEntity);
            response.put("message", "Associação alterada com sucesso!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao alterar associação!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir(Long id){
        TurmaDisciplinaEntity turmaDisciplinaEntity = turmaDisciplinaRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try{
            turmaDisciplinaRepository.delete(turmaDisciplinaEntity);
            response.put("message", "Associação removida com sucesso!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao remover associação!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
