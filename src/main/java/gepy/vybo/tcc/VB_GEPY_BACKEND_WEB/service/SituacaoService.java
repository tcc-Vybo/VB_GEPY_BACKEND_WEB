package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.SituacaoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.SituacaoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.SituacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SituacaoService {

    @Autowired
    private SituacaoRepository situacaoRepository;

    public List<SituacaoDTO> listarTodos(){
        List<SituacaoEntity> situacoes = situacaoRepository.findAllOrderedById();
        return situacoes.stream().map(SituacaoDTO::new).toList();
    }

    public ResponseEntity<Map<String, String>> inserir(SituacaoDTO situacao){
        SituacaoEntity situacaoEntity = new SituacaoEntity(situacao);
        Map<String, String> response = new HashMap<>();
        try{
            situacaoRepository.save(situacaoEntity);
            response.put("message", "Situação criada com sucesso!");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("error", "Erro ao criar situação" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterar(SituacaoDTO situacao){
        SituacaoEntity situacaoEntity = new SituacaoEntity(situacao);
        Map<String, String> response = new HashMap<>();
        try{
            situacaoRepository.save(situacaoEntity);
            response.put("message", "Situação alterada com sucesso!");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("error", "Erro ao alterar situacao" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir(Long id){
        SituacaoEntity situacaoEntity = situacaoRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try{
            situacaoRepository.delete(situacaoEntity);
            response.put("message", "Situação apagada com sucesso!");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("error", "Erro ao apagar situacao" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
