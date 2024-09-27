package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.EventoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.EventoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<EventoDTO> listarTodos(){
        List<EventoEntity> eventos = eventoRepository.findAll();
        return eventos.stream().map(EventoDTO::new).toList();
    }

    public void inserir(EventoDTO evento){
        EventoEntity eventoEntity = new EventoEntity(evento);
        eventoRepository.save(eventoEntity);
    }


    public EventoDTO alterar(EventoDTO evento){
        EventoEntity eventoEntity = new EventoEntity(evento);
        return new EventoDTO(eventoRepository.save(eventoEntity));
    }

    public void excluir(Long id){
        EventoEntity eventoEntity = eventoRepository.findById(id).get();
        eventoRepository.delete(eventoEntity);
    }
}
