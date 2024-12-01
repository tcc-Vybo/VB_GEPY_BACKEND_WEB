package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.AlunoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/aluno")
@CrossOrigin
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<AlunoDTO> ListarTodos(){
        return alunoService.ListarTodos();
    }

    @GetMapping("/buscar/{nomeCompleto}")
    public ResponseEntity<List<AlunoDTO>> buscarPorNome(@PathVariable String nomeCompleto) {
        List<AlunoDTO> alunos = alunoService.buscarPorNome(nomeCompleto);
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/login/{cpf}/{email}")
    public ResponseEntity<AlunoDTO> buscaPorCpfEmail(@PathVariable("cpf") String cpf , @PathVariable("email") String email){
        AlunoDTO aluno = alunoService.buscaPorCpfEmail(cpf, email);
        return ResponseEntity.ok(aluno);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> inserir(@RequestBody AlunoDTO aluno){
        return alunoService.inserir(aluno);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> alterar (@RequestBody AlunoDTO aluno){
        return alunoService.alterar(aluno);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Map<String, String>> alterValue (@RequestBody AlunoDTO aluno, @PathVariable Long id){
        return alunoService.alterValue(aluno, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable("id") Long id){
       return alunoService.excluir(id);
    }


};
