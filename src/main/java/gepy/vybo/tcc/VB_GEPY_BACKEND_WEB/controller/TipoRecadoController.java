package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.TipoRecadoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.TipoRecadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tipo-recado")
@CrossOrigin
public class TipoRecadoController {

    @Autowired
    private TipoRecadoService tipoRecadoService;

    @GetMapping
    public List<TipoRecadoDTO> listarTodos(){
        return tipoRecadoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> inserir(@RequestBody TipoRecadoDTO tipoRecado){
        return tipoRecadoService.inserir(tipoRecado);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> alterar(@RequestBody TipoRecadoDTO tipoRecado){
        return tipoRecadoService.alterar(tipoRecado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable("id") Long id){
        return tipoRecadoService.excluir(id);
    }
}
