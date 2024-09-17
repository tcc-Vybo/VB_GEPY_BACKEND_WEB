package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.FuncionarioDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionario")
@CrossOrigin
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public  List<FuncionarioDTO> ListarTodos(){
        return funcionarioService.ListarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody FuncionarioDTO funcionario){
        funcionarioService.inserir(funcionario);
    }

    @PutMapping
    public FuncionarioDTO alterar (@RequestBody FuncionarioDTO funcionario){
        return funcionarioService.alterar(funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        funcionarioService.excluir(id);
        return ResponseEntity.ok().build();
    }















}
