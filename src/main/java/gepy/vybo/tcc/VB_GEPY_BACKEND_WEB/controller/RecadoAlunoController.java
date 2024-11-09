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

    @GetMapping("/buscar/tiporecado/{tipoRecado}")
    public ResponseEntity<List<RecadoAlunoDTO>> buscarPorTipoRecado(@PathVariable("tipoRecado") Long idTipoRecado){
        List<RecadoAlunoDTO> recados = recadoAlunoService.buscarPorTipoRecado(idTipoRecado);
        return ResponseEntity.ok(recados);
    }

    @GetMapping("/buscar/remetente/{remetente}")
    public ResponseEntity<List<RecadoAlunoDTO>> buscarPorRemetente(@PathVariable("remetente") Long idRemetente){
        List<RecadoAlunoDTO> recados = recadoAlunoService.buscarPorRemetente(idRemetente);
        return ResponseEntity.ok(recados);
    }

    @GetMapping("/buscar/destinatario/{destinatario}")
    public ResponseEntity<List<RecadoAlunoDTO>> buscarPorDestinatario(@PathVariable("destinatario") Long idDestinatario){
        List<RecadoAlunoDTO> recados = recadoAlunoService.buscarPorDestinatario(idDestinatario);
        return ResponseEntity.ok(recados);
    }

    @GetMapping("/buscar/status/{status}")
    public ResponseEntity<List<RecadoAlunoDTO>> buscarPorStatus(@PathVariable String status){
        List<RecadoAlunoDTO> recados = recadoAlunoService.buscarPorStatus(status);
        return ResponseEntity.ok(recados);
    }

    @GetMapping("/buscar/data/{data}")
    public ResponseEntity<List<RecadoAlunoDTO>> buscarPorData(@PathVariable String data){
        List<RecadoAlunoDTO> recados = recadoAlunoService.buscarPorData(data);
        return ResponseEntity.ok(recados);
    }

    @GetMapping("/buscar/datadeenvio/{dataDeEnvio}")
    public ResponseEntity<List<RecadoAlunoDTO>> buscarPorDataDeEnvio(@PathVariable String dataDeEnvio){
        List<RecadoAlunoDTO> recados = recadoAlunoService.buscarPorDataDeEnvio(dataDeEnvio);
        return ResponseEntity.ok(recados);
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
