package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.TurmaDisciplinaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.TurmaDisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/turma-disciplina")
@CrossOrigin
public class TurmaDisciplinaController {

    @Autowired
    private TurmaDisciplinaService turmaDisciplinaService;

    @GetMapping
    public List<TurmaDisciplinaDTO> listarTodos(){
        return turmaDisciplinaService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> inserir(@RequestBody TurmaDisciplinaDTO turmaDisciplina){
        return turmaDisciplinaService.inserir(turmaDisciplina);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> alterar(@RequestBody TurmaDisciplinaDTO turmaDisciplina){
        return turmaDisciplinaService.alterar(turmaDisciplina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable("id") Long id){
        return turmaDisciplinaService.excluir(id);
    }
}
