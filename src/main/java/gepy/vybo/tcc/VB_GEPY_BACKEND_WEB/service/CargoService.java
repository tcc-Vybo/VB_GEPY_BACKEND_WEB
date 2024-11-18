package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.CargoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.CargoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public List<CargoDTO> listarTodos(){
        List<CargoEntity> cargo = cargoRepository.findAllOrderedById();
        return cargo.stream().map(CargoDTO::new).toList();
    }

    public ResponseEntity<Map<String, String>> inserir (CargoDTO cargo){
        CargoEntity cargoEntity = new CargoEntity(cargo);
        Map<String, String> response = new HashMap<>();
        try {
            cargoRepository.save(cargoEntity);
            response.put("message", "Cargo inserido com sucesso!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao inserir cargo!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterar (CargoDTO cargo){
        CargoEntity cargoEntity = new CargoEntity(cargo);
        Map<String, String> response = new HashMap<>();
        try{
            cargoRepository.save(cargoEntity);
            response.put("message", "Cargo alterado com sucesso!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "Erro ao alterar cargo!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir (Long id){
        CargoEntity cargoEntity = cargoRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try{
            cargoRepository.delete(cargoEntity);
            response.put("message", "Cargo excluido com sucesso!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao excluir cargo!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
