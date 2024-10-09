package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.EventoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/evento")
@CrossOrigin
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<EventoDTO> listarTodos(){
        return eventoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> inserir(@RequestBody EventoDTO evento){
        return eventoService.inserir(evento);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> alterar(@RequestBody EventoDTO evento){
        return eventoService.alterar(evento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable("id") Long id){
        return eventoService.excluir(id);
    }
}
