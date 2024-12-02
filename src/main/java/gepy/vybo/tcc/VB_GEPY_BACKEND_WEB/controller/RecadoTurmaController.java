package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.FuncionarioDTO;
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

    @GetMapping("/buscar/tiporecado/{tipoRecado}")
    public ResponseEntity<List<RecadoTurmaDTO>> buscarPorTipoRecado(@PathVariable("tipoRecado") Long idTipoRecado){
        List<RecadoTurmaDTO> recados = recadoTurmaService.buscarPorTipoRecado(idTipoRecado);
        return ResponseEntity.ok(recados);
    }

    @GetMapping("/buscar/remetente/{remetente}")
    public ResponseEntity<List<RecadoTurmaDTO>> buscarPorRemetente(@PathVariable("remetente") Long idRemetente){
        List<RecadoTurmaDTO> recados = recadoTurmaService.buscarPorRemetente(idRemetente);
        return ResponseEntity.ok(recados);
    }

    @GetMapping("/buscar/destinatario/{destinatario}")
    public ResponseEntity<List<RecadoTurmaDTO>> buscarPorDestinatario(@PathVariable("destinatario") Long idDestinatario){
        List<RecadoTurmaDTO> recados = recadoTurmaService.buscarPorDestinatario(idDestinatario);
        return ResponseEntity.ok(recados);
    }

    @GetMapping("/buscar/status/{status}")
    public ResponseEntity<List<RecadoTurmaDTO>> buscarPorStatus(@PathVariable String status){
        List<RecadoTurmaDTO> recados = recadoTurmaService.buscarPorStatus(status);
        return ResponseEntity.ok(recados);
    }

    @GetMapping("/buscar/data/{data}")
    public ResponseEntity<List<RecadoTurmaDTO>> buscarPorData(@PathVariable String data){
        List<RecadoTurmaDTO> recados = recadoTurmaService.buscarPorData(data);
        return ResponseEntity.ok(recados);
    }

    @GetMapping("/buscar/datadeenvio/{dataDeEnvio}")
    public ResponseEntity<List<RecadoTurmaDTO>> buscarPorDataDeEnvio(@PathVariable String dataDeEnvio){
        List<RecadoTurmaDTO> recados = recadoTurmaService.buscarPorDataDeEnvio(dataDeEnvio);
        return ResponseEntity.ok(recados);
    }

    @GetMapping("/buscar-filtros")
    public ResponseEntity<List<RecadoTurmaDTO>> buscarPorFiltros(
            @RequestParam(required = false) String dataMarcada,
            @RequestParam(required = false) String dataDeEnvio,
            @RequestParam(required = false) Long remetente,
            @RequestParam(required = false) Long destinatario,
            @RequestParam(required = false) Long tipoRecado) {

        List<RecadoTurmaDTO> recados = recadoTurmaService.buscarPorFiltros(dataMarcada, dataDeEnvio, remetente, destinatario, tipoRecado);
        return ResponseEntity.ok(recados);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> inserir(@RequestBody RecadoTurmaDTO recadoTurma){
        return recadoTurmaService.inserir(recadoTurma);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> alterar(@RequestBody RecadoTurmaDTO recadoTurma){
        return recadoTurmaService.alterar(recadoTurma);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Map<String, String>> alterValue (@RequestBody RecadoTurmaDTO recadoTurma, @PathVariable Long id){
        return recadoTurmaService.alterValue(recadoTurma, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable("id") Long id){
        return recadoTurmaService.excluir(id);
    }
}
