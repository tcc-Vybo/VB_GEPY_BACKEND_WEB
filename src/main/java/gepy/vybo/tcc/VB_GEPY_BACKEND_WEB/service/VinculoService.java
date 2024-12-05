package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.ProfessorDisciplinaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.VinculoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.*;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.VinculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VinculoService {

    @Autowired
    private VinculoRepository vinculoRepository;

    public List<VinculoDTO> listarVinculos() {
        List<VinculoEntity> vinculos = vinculoRepository.findAllOrderedById();
        return vinculos.stream().map(VinculoDTO::new).collect(Collectors.toList());
    }

    public List<VinculoDTO> buscarPorCargo(Long idCargo){
        List<VinculoEntity> vinculos = vinculoRepository.findFuncionarioByCargo(idCargo);
        return vinculos.stream().map(VinculoDTO::new).collect(Collectors.toList());
    }

    public ResponseEntity<Map<String, String>> inserir(VinculoDTO vinculo) {
        FuncionarioEntity funcionarioEntity = new FuncionarioEntity(vinculo.getFuncionario());
        CargoEntity cargoEntity = new CargoEntity(vinculo.getCargo());

        VinculoEntity vinculoEntity = new VinculoEntity(vinculo);
        Map<String, String> response = new HashMap<>();
        try{
            if (vinculoRepository.existsByFuncionarioAndCargo(funcionarioEntity, cargoEntity)) {
                throw new IllegalArgumentException(" O funcionário já está associado a esse cargo.");
            }
            vinculoRepository.save(vinculoEntity);
            response.put("message", "Funcionário associado ao cargo com sucesso!");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("error", "Erro ao associar funcionario! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

    public ResponseEntity<Map<String, String>> alterar(VinculoDTO vinculo) {
        VinculoEntity vinculoEntity = new VinculoEntity(vinculo);
        Map<String, String> response = new HashMap<>();
        try{
            vinculoRepository.save(vinculoEntity);
            response.put("message", "Associação alterada com sucesso!");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("error", "Erro ao alterar associação!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir(Long id) {
        VinculoEntity vinculoEntity = vinculoRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try{
            vinculoRepository.delete(vinculoEntity);
            response.put("message", "Associação excluída com sucesso!");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("error", "Erro ao excluir associação!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
