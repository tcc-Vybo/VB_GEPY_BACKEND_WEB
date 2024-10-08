package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.RecadoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.RecadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/recado")
@CrossOrigin
public class RecadoController {

    @Autowired
    private RecadoService recadoService;

    @GetMapping
    public List<RecadoDTO> listarTodos(){
        return recadoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> inserir(@RequestBody RecadoDTO recado){
       return recadoService.inserir(recado);
    }

    @PutMapping
    public RecadoDTO alterar(@RequestBody RecadoDTO recado){
        return recadoService.alterar(recado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir (@PathVariable("id") Long id){
        recadoService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
