package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.FuncionarioDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/funcionario")
@CrossOrigin
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<FuncionarioDTO> ListarTodos(){
        return funcionarioService.ListarTodos();
    }

    @GetMapping("/buscar/{nomeCompleto}")
    public ResponseEntity<List<FuncionarioDTO>> buscarPorNome(@PathVariable String nomeCompleto){
        List<FuncionarioDTO> funcionarios = funcionarioService.buscarPorNome(nomeCompleto);
        return ResponseEntity.ok(funcionarios);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> inserir(@RequestBody FuncionarioDTO funcionario){
        return funcionarioService.inserir(funcionario);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> alterar (@RequestBody FuncionarioDTO funcionario){
        return funcionarioService.alterar(funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable("id") Long id){
        return funcionarioService.excluir(id);
    }















}
