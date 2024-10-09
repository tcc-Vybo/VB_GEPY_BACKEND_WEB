package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.MateriaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.MateriaEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public List<MateriaDTO> listarMaterias(){
        List<MateriaEntity> materias = materiaRepository.findAll();
        return materias.stream().map(MateriaDTO::new).toList();
    }

    public ResponseEntity<Map<String, String>> inserir(MateriaDTO materia){
        MateriaEntity materiaEntity = new MateriaEntity(materia);
        Map<String, String> response = new HashMap<>();
        try {
            materiaRepository.save(materiaEntity);
            response.put("message", "Materia registrada com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao inserir materia!!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterar(MateriaDTO materia){
        MateriaEntity materiaEntity = new MateriaEntity(materia);
        Map<String, String> response = new HashMap<>();
        try{
            materiaRepository.save(materiaEntity);
            response.put("message", "Materia alterada com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao alterar materia!!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir(Long id){
        MateriaEntity materiaEntity = materiaRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try {
            materiaRepository.delete(materiaEntity);
            response.put("message", "Materia removida com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao remover materia!!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
