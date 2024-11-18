package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.controller;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.CargoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cargo")
@CrossOrigin
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping
    public List<CargoDTO> listarTodos(){
        return cargoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> inserir(@RequestBody CargoDTO cargoDTO){
        return cargoService.inserir(cargoDTO);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> alterar(@RequestBody CargoDTO cargoDTO){
        return cargoService.alterar(cargoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable("id") Long id){
        return cargoService.excluir(id);
    }
}
