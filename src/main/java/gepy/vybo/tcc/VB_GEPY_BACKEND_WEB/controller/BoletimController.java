package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.BoletimDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.BoletimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/boletim")
@CrossOrigin
public class BoletimController {

    @Autowired
    private BoletimService boletimService;

    @GetMapping
    public List<BoletimDTO> listarTodos(){
        return boletimService.listarTodos();
    }

    @GetMapping("/buscar/{disciplina}")
    public ResponseEntity<List<BoletimDTO>> buscarPorDisciplina(@PathVariable("disciplina") Long idDisciplina){
        List<BoletimDTO> notas = boletimService.buscarPorDisciplina(idDisciplina);
        return ResponseEntity.ok(notas);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> inserir(@RequestBody BoletimDTO boletim){
        return boletimService.inserir(boletim);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> alterar(@RequestBody BoletimDTO boletim){
        return boletimService.alterar(boletim);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable("id") Long id){
        return boletimService.excluir(id);
    }
}
