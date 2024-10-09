package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.BoletimDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.BoletimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public void inserir(@RequestBody BoletimDTO boletim){
        boletimService.inserir(boletim);
    }

    @PutMapping
    public BoletimDTO alterar(@RequestBody BoletimDTO boletim){
        return boletimService.alterar(boletim);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        boletimService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
