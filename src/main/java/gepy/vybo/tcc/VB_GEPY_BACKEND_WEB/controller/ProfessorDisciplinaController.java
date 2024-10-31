package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.ProfessorDisciplinaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.ProfessorDisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/professor-disciplina")
@CrossOrigin
public class ProfessorDisciplinaController {

    @Autowired
    private ProfessorDisciplinaService professorDisciplinaService;

    @GetMapping
    public List<ProfessorDisciplinaDTO> listarTodos(){
        return professorDisciplinaService.listarTodos();
    }

    @GetMapping("/buscar/{disciplina}")
    public ResponseEntity<List<ProfessorDisciplinaDTO>> buscarPorDisciplina(@PathVariable("disciplina") Long idDisciplina){
        List<ProfessorDisciplinaDTO> professorDisciplinas = professorDisciplinaService.buscarPorDisciplina(idDisciplina);
        return ResponseEntity.ok(professorDisciplinas);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> inserir(@RequestBody ProfessorDisciplinaDTO professorDisciplina){
        return professorDisciplinaService.inserir(professorDisciplina);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> alterar(@RequestBody ProfessorDisciplinaDTO professorDisciplina){
        return professorDisciplinaService.alterar(professorDisciplina);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable Long id){
        return professorDisciplinaService.excluir(id);
    }
}
