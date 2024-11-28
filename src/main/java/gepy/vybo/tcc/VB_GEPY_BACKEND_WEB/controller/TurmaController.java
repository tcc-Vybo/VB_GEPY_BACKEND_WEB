package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.FuncionarioDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.TurmaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String, String>> inserir(@RequestBody TurmaDTO turma){
        return turmaService.inserir(turma);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> alterar(@RequestBody TurmaDTO turma){
        return turmaService.alterar(turma);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Map<String, String>> alterValue (@RequestBody TurmaDTO turma, @PathVariable Long id){
        return turmaService.alterValue(turma, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> remover(@PathVariable("id") Long id){
        return turmaService.excluir(id);
    }
}
