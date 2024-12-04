package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.AlunoTurmaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.AlunoTurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/aluno-turma")
@CrossOrigin
public class AlunoTurmaController {

    @Autowired
    private AlunoTurmaService alunoTurmaService;

    @GetMapping
    public List<AlunoTurmaDTO> listarTodos(){
        return alunoTurmaService.listarTodos();
    }

    @GetMapping("/buscar/{turma}")
    public ResponseEntity<List<AlunoTurmaDTO>> buscarPorTurma(@PathVariable("turma") Long idTurma){
        List<AlunoTurmaDTO> alunoTurmas = alunoTurmaService.buscarPorTurma(idTurma);
        return ResponseEntity.ok(alunoTurmas);
    }

    @GetMapping("/buscarVinculo/{aluno}")
    public ResponseEntity<List<AlunoTurmaDTO>> buscarPorVinculoAlunoTurma(@PathVariable("aluno") Long idAluno){
        List<AlunoTurmaDTO> alunoTurmas = alunoTurmaService.buscarPorAluno(idAluno);
        return ResponseEntity.ok(alunoTurmas);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> inserir(@RequestBody AlunoTurmaDTO alunoTurma){
        return alunoTurmaService.inserir(alunoTurma);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> alterar(@RequestBody AlunoTurmaDTO alunoTurma){
        return alunoTurmaService.alterar(alunoTurma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable("id") Long id){
        return alunoTurmaService.excluir(id);
    }
}
