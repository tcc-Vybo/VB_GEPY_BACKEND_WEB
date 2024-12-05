package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.ProfessorDisciplinaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.VinculoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.VinculoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.VinculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vinculo")
@CrossOrigin
public class VinculoController {

    @Autowired
    private VinculoService vinculoService;

    @GetMapping
    public List<VinculoDTO> listarTodos(){
        return vinculoService.listarVinculos();
    }

    @GetMapping("/buscar/{cargo}")
    public ResponseEntity<List<VinculoDTO>> buscarPorCargo(@PathVariable("cargo") Long idCargo){
        List<VinculoDTO> vinculos = vinculoService.buscarPorCargo(idCargo);
        return ResponseEntity.ok(vinculos);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> inserir(@RequestBody VinculoDTO vinculoDTO){
        return vinculoService.inserir(vinculoDTO);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> alterar(@RequestBody VinculoDTO vinculoDTO){
        return vinculoService.alterar(vinculoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable Long id){
        return vinculoService.excluir(id);
    }


}
