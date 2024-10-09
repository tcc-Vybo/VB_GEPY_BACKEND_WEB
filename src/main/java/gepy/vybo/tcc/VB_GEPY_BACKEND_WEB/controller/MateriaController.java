package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.MateriaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String, String>> inserir(@RequestBody MateriaDTO materia){
       return materiaService.inserir(materia);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> alterar(@RequestBody MateriaDTO materia){
        return materiaService.alterar(materia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable("id") Long id){
        return materiaService.excluir(id);
    }
}
