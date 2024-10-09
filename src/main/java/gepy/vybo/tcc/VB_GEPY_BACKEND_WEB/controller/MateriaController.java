package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.MateriaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materia")
@CrossOrigin
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public List<MateriaDTO> listarTodos(){
        return materiaService.listarMaterias();
    }

    @PostMapping
    public void inserir(@RequestBody MateriaDTO materia){
        materiaService.inserir(materia);
    }

    @PutMapping
    public MateriaDTO alterar(@RequestBody MateriaDTO materia){
        return materiaService.alterar(materia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        materiaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
