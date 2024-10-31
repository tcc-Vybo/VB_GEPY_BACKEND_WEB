package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.DisciplinaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/disciplina")
@CrossOrigin
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public List<DisciplinaDTO> listarTodos(){
        return disciplinaService.listarTodos();
    }

    @GetMapping("/buscar/{nome}")
    public ResponseEntity<List<DisciplinaDTO>> buscarPorNome(@PathVariable String nome){
        List<DisciplinaDTO> disciplinas = disciplinaService.buscarPorNome(nome);
        return ResponseEntity.ok(disciplinas);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> inserir(@RequestBody DisciplinaDTO disciplina){
       return disciplinaService.inserir(disciplina);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> alterar(@RequestBody DisciplinaDTO disciplina){
        return disciplinaService.alterar(disciplina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable("id") Long id){
        return disciplinaService.excluir(id);
    }
}
