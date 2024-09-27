package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.TurmaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/turma")
@CrossOrigin
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public List<TurmaDTO> listarTodos(){
        return turmaService.listarTodos();
    }

    @GetMapping("/buscar/{nome}")
    public ResponseEntity<List<TurmaDTO>> buscarPorNome(@PathVariable String nome){
        List<TurmaDTO> turmas = turmaService.buscarPorNome(nome);
        return ResponseEntity.ok(turmas);
    }

    @PostMapping
    public void inserir(@RequestBody TurmaDTO turma){
        turmaService.inserir(turma);
    }

    @PutMapping
    public TurmaDTO alterar(@RequestBody TurmaDTO turma){
        return turmaService.alterar(turma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable("id") Long id){
        turmaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
