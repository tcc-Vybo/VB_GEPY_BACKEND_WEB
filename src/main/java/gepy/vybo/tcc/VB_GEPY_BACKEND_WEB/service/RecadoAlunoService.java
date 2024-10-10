package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.RecadoAlunoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.RecadoAlunoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.RecadoAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecadoAlunoService {

    @Autowired
    private RecadoAlunoRepository recadoAlunoRepository;

    public List<RecadoAlunoDTO> listarTodos(){
        List<RecadoAlunoEntity> recadoAluno = recadoAlunoRepository.findAll();
        return recadoAluno.stream().map(RecadoAlunoDTO::new).toList();
    }

    public ResponseEntity<Map<String, String>> inserir(RecadoAlunoDTO recadoAluno){
        RecadoAlunoEntity recadoAlunoEntity = new RecadoAlunoEntity(recadoAluno);
        Map<String, String> response = new HashMap<>();
        try {
            recadoAlunoRepository.save(recadoAlunoEntity);
            response.put("message", "Recado postado com sucesso!!");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("error", "Erro ao postar recado!!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterar(RecadoAlunoDTO recadoAluno){
        RecadoAlunoEntity recadoAlunoEntity = new RecadoAlunoEntity(recadoAluno);
        Map<String, String> response = new HashMap<>();
        try{
            recadoAlunoRepository.save(recadoAlunoEntity);
            response.put("message", "Recado alterado com sucesso!!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "Erro ao alterar recado!!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir(Long id){
        RecadoAlunoEntity recadoAluno = recadoAlunoRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try {
            recadoAlunoRepository.delete(recadoAluno);
            response.put("message", "Recado excluido com sucesso!!");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("error", "Erro ao excluir recado!!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
