package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.RecadoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.RecadoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.RecadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecadoService {

    @Autowired
    private RecadoRepository recadoRepository;

    public List<RecadoDTO> listarTodos(){
        List<RecadoEntity> recado = recadoRepository.findAll();
        return recado.stream().map(RecadoDTO::new).toList();
    }

    public ResponseEntity<Map<String, String>> inserir(RecadoDTO recado){
        RecadoEntity recadoEntity = new RecadoEntity(recado);

        Map<String, String> response = new HashMap<>();

        try {
            recadoRepository.save(recadoEntity);
            response.put("message", "Evento inserido com sucesso!!");
            return ResponseEntity.ok(response);

        }catch(Exception e){
            response.put("error", "Evento não inserido!!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }


    }

    public RecadoDTO alterar(RecadoDTO recado){
        RecadoEntity recadoEntity = new RecadoEntity(recado);
        return new RecadoDTO(recadoRepository.save(recadoEntity));
    }

    public void excluir(Long id){
        RecadoEntity recado = recadoRepository.findById(id).get();
        recadoRepository.delete(recado);
    }
}
