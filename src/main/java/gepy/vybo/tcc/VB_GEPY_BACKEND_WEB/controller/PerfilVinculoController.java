package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.AlunoTurmaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.PerfilVinculoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.TurmaDisciplinaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.PerfilVinculoService;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.TurmaDisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/perfil-vinculo")
@CrossOrigin
public class PerfilVinculoController {

    @Autowired
    private PerfilVinculoService perfilVinculoService;

    @GetMapping
    public List<PerfilVinculoDTO> listarTodos(){
        return perfilVinculoService.listarTodos();
    }

    @GetMapping("/buscarVinculoByFuncionario/{funcionario}")
    public ResponseEntity<List<PerfilVinculoDTO>> buscarPorVinculoAlunoTurma(@PathVariable("funcionario") Long idFuncionario){
        List<PerfilVinculoDTO> perfilVinculo = perfilVinculoService.buscarVinculoByFuncionario(idFuncionario);
        return ResponseEntity.ok(perfilVinculo);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> inserir(@RequestBody PerfilVinculoDTO perfilVinculo){
        return perfilVinculoService.inserir(perfilVinculo);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> alterar(@RequestBody PerfilVinculoDTO perfilVinculo){
        return perfilVinculoService.alterar(perfilVinculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable("id") Long id){
        return perfilVinculoService.excluir(id);
    }
}
