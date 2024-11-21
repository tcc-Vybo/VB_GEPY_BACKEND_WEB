package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.TipoRecadoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.TipoRecadoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.TipoRecadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TipoRecadoService {

    @Autowired
    private TipoRecadoRepository tipoRecadoRepository;

    public List<TipoRecadoDTO> listarTodos(){
        List<TipoRecadoEntity> tipoRecados = tipoRecadoRepository.findAllOrderedById();
        return tipoRecados.stream().map(TipoRecadoDTO::new).toList();
    }

    public ResponseEntity<Map<String, String>> inserir(TipoRecadoDTO tipoRecado){
        TipoRecadoEntity tipoRecadoEntity = new TipoRecadoEntity(tipoRecado);
        Map<String, String> response = new HashMap<>();
        try{
            tipoRecadoRepository.save(tipoRecadoEntity);
            response.put("message", "Tipo de recado adicionado com sucesso!");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("error", "Erro ao inserir tipo de recado!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterar(TipoRecadoDTO tipoRecado){
        TipoRecadoEntity tipoRecadoEntity = new TipoRecadoEntity(tipoRecado);
        Map<String, String> response = new HashMap<>();

        try{
            tipoRecadoRepository.save(tipoRecadoEntity);
            response.put("message", "Tipo de recado alterado com sucesso!");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("error", "Erro ao alterar tipo de recado!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir(Long id){
        TipoRecadoEntity tipoRecadoEntity = tipoRecadoRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try{
            tipoRecadoRepository.delete(tipoRecadoEntity);
            response.put("message", "Tipo de recado excluido com sucesso!");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("error", "Erro ao excluir tipo de recado!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
