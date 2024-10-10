package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.RecadoAlunoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.RecadoAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/recado-aluno")
@CrossOrigin
public class RecadoAlunoController {

    @Autowired
    private RecadoAlunoService recadoAlunoService;

    @GetMapping
    public List<RecadoAlunoDTO> listarTodos(){
        return recadoAlunoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> inserir(@RequestBody RecadoAlunoDTO recadoAluno){
       return recadoAlunoService.inserir(recadoAluno);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> alterar(@RequestBody RecadoAlunoDTO recadoAluno){
        return recadoAlunoService.alterar(recadoAluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir (@PathVariable("id") Long id){
        return recadoAlunoService.excluir(id);
    }

}
