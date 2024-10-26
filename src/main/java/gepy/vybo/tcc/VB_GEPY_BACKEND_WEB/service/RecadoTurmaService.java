package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.RecadoTurmaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.RecadoTurmaEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.RecadoTurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RecadoTurmaService {

    @Autowired
    private RecadoTurmaRepository recadoTurmaRepository;

    public List<RecadoTurmaDTO> listarTodos(){
        List<RecadoTurmaEntity> recadoTurma = recadoTurmaRepository.findAllOrderedById();
        return recadoTurma.stream().map(RecadoTurmaDTO::new).toList();
    }

    public List<RecadoTurmaDTO> buscarPorTipoRecado(Long idTipoRecado){
        List<RecadoTurmaEntity> recadoTurmaPorTipo = recadoTurmaRepository.findAllByTipoRecado(idTipoRecado);
        return recadoTurmaPorTipo.stream().map(RecadoTurmaDTO::new).collect(Collectors.toList());
    }

    public ResponseEntity<Map<String, String>> inserir(RecadoTurmaDTO recadoTurma){
        RecadoTurmaEntity recadoTurmaEntity = new RecadoTurmaEntity(recadoTurma);
        Map<String, String> response = new HashMap<>();
        try {
            recadoTurmaRepository.save(recadoTurmaEntity);
            response.put("message", "Recado postado com sucesso!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao inserir recado!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterar(RecadoTurmaDTO recadoTurma){
        RecadoTurmaEntity recadoTurmaEntity = new RecadoTurmaEntity(recadoTurma);
        Map<String, String> response = new HashMap<>();
        try{
            recadoTurmaRepository.save(recadoTurmaEntity);
            response.put("message", "Recado alterado com sucesso!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao alterar recado!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir(Long id){
        RecadoTurmaEntity recadoTurmaEntity = recadoTurmaRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try {
            recadoTurmaRepository.delete(recadoTurmaEntity);
            response.put("message", "Recado excluido com sucesso!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao excluir recado!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
