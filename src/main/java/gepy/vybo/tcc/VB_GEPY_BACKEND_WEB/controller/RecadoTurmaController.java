package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.RecadoTurmaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.RecadoTurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/recado-turma")
@CrossOrigin
public class RecadoTurmaController {

    @Autowired
    private RecadoTurmaService recadoTurmaService;

    @GetMapping
    public List<RecadoTurmaDTO> listarTodos(){
        return recadoTurmaService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> inserir(@RequestBody RecadoTurmaDTO recadoTurma){
        return recadoTurmaService.inserir(recadoTurma);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> alterar(@RequestBody RecadoTurmaDTO recadoTurma){
        return recadoTurmaService.alterar(recadoTurma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable("id") Long id){
        return recadoTurmaService.excluir(id);
    }
}
