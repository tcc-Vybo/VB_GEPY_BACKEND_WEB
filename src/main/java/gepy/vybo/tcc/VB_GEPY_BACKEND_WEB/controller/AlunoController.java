package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.AlunoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<AlunoDTO> buscarAlunoPorNome(@PathVariable String nomeCompleto){
        return alunoService.buscarAlunoPorNome(nomeCompleto);
    }

    @PostMapping
    public void inserir(@RequestBody AlunoDTO aluno){
        alunoService.inserir(aluno);
    }

    @PutMapping
    public AlunoDTO alterar (@RequestBody AlunoDTO aluno){
        return alunoService.alterar(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        alunoService.excluir(id);
        return ResponseEntity.ok().build();
    }


};
