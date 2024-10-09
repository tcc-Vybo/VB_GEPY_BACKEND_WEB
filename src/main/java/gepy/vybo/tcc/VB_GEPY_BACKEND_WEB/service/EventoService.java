package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.EventoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.EventoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<EventoDTO> listarTodos(){
        List<EventoEntity> eventos = eventoRepository.findAll();
        return eventos.stream().map(EventoDTO::new).toList();
    }

    public ResponseEntity<Map<String, String>> inserir(EventoDTO evento){
        EventoEntity eventoEntity = new EventoEntity(evento);
        Map<String, String> response = new HashMap<>();
        try {
            eventoRepository.save(eventoEntity);
            response.put("message", "Evento postado com sucesso!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao inserir evento!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterar(EventoDTO evento){
        EventoEntity eventoEntity = new EventoEntity(evento);
        Map<String, String> response = new HashMap<>();
        try{
            eventoRepository.save(eventoEntity);
            response.put("message", "Evento alterado com sucesso!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao alterar evento!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir(Long id){
        EventoEntity eventoEntity = eventoRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try {
            eventoRepository.delete(eventoEntity);
            response.put("message", "Evento excluido com sucesso!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao excluir evento!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
