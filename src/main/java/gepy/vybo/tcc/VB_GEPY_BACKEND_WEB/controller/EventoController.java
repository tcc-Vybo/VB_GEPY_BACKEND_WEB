package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.EventoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/evento")
@CrossOrigin
public class EventoController {

    @Autowired
    private EventoService eventoService;

    public List<EventoDTO> listarTodos(){
        return eventoService.listarTodos();
    }

    public void inserir(EventoDTO evento){
        eventoService.inserir(evento);
    }

    public EventoDTO alterar(EventoDTO evento){
        return eventoService.alterar(evento);
    }

    public ResponseEntity<Void> excluir(Long id){
        eventoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
