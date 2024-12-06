package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.AlunoTurmaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.PerfilVinculoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.TurmaDisciplinaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.AlunoTurmaEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.PerfilVinculoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.TurmaDisciplinaEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.PerfilVinculoRepository;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.TurmaDisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PerfilVinculoService {

    @Autowired
    private PerfilVinculoRepository perfilVinculoRepository;

    public List<PerfilVinculoDTO> listarTodos(){
        List<PerfilVinculoEntity> perfilVinculo = perfilVinculoRepository.findAllOrderedById();
        return perfilVinculo.stream().map(PerfilVinculoDTO::new).toList();
    }

    public List<PerfilVinculoDTO> buscarVinculoByFuncionario(Long idFuncionario){
        List<PerfilVinculoEntity> perfilVinculo = perfilVinculoRepository.findAllVinculosByFuncionarioId(idFuncionario);
        return perfilVinculo.stream().map(PerfilVinculoDTO::new).collect(Collectors.toList());
    }

    public ResponseEntity<Map<String, String>> inserir(PerfilVinculoDTO perfilVinculo){
        PerfilVinculoEntity perfilVinculoEntity = new PerfilVinculoEntity(perfilVinculo);
        Map<String, String> response = new HashMap<>();
        try{
            perfilVinculoRepository.save(perfilVinculoEntity);
            response.put("message", "Perfil associado ao funcionario com sucesso!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao associar perfil!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterar(PerfilVinculoDTO perfilVinculo){
        PerfilVinculoEntity perfilVinculoEntity = new PerfilVinculoEntity(perfilVinculo);
        Map<String, String> response = new HashMap<>();
        try{
            perfilVinculoRepository.save(perfilVinculoEntity);
            response.put("message", "Associação alterada com sucesso!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao alterar associação!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir(Long id){
        PerfilVinculoEntity perfilVinculoEntity = perfilVinculoRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try{
            perfilVinculoRepository.delete(perfilVinculoEntity);
            response.put("message", "Associação removida com sucesso!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao remover associação!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
