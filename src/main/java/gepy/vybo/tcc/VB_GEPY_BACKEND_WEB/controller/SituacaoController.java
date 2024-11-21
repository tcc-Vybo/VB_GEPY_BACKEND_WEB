package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.SituacaoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.SituacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/situacao")
@CrossOrigin
public class SituacaoController {

    @Autowired
    private SituacaoService situacaoService;

    @GetMapping
    public List<SituacaoDTO> listarTodos(){
        return situacaoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> inserir(@RequestBody SituacaoDTO situacao){
        return situacaoService.inserir(situacao);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> alterar(@RequestBody SituacaoDTO situacao){
        return situacaoService.alterar(situacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable Long id){
        return situacaoService.excluir(id);
    }
}
