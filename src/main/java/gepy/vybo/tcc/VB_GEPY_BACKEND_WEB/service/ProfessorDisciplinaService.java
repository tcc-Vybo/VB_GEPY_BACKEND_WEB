package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.ProfessorDisciplinaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.DisciplinaEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.FuncionarioEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.ProfessorDisciplinaEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.ProfessorDisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProfessorDisciplinaService {

    @Autowired
    private ProfessorDisciplinaRepository professorDisciplinaRepository;

    public List<ProfessorDisciplinaDTO> listarTodos(){
        List<ProfessorDisciplinaEntity> professorDisciplina = professorDisciplinaRepository.findAllOrderedById();
        return professorDisciplina.stream().map(ProfessorDisciplinaDTO::new).toList();
    }

    public List<ProfessorDisciplinaDTO> buscarPorDisciplina(Long idDisciplina){
        List<ProfessorDisciplinaEntity> professorDisciplinas = professorDisciplinaRepository.findProfessorByDisciplina(idDisciplina);
        return professorDisciplinas.stream().map(ProfessorDisciplinaDTO::new).collect(Collectors.toList());
    }

    public ResponseEntity<Map<String, String>> inserir(ProfessorDisciplinaDTO professorDisciplina){
        FuncionarioEntity professorEntity = new FuncionarioEntity(professorDisciplina.getProfessor());  // Converte FuncionarioDTO para FuncionarioEntity
        DisciplinaEntity disciplinaEntity = new DisciplinaEntity(professorDisciplina.getDisciplina());  // Converte DisciplinaDTO para DisciplinaEntity

        ProfessorDisciplinaEntity professorDisciplinaEntity = new ProfessorDisciplinaEntity(professorDisciplina);
        Map<String, String> response = new HashMap<>();
        try{
            if (professorDisciplinaRepository.existsByProfessorAndDisciplina(professorEntity, disciplinaEntity)) {
                throw new IllegalArgumentException(" O professor já está associado a essa disciplina.");
            }
            professorDisciplinaRepository.save(professorDisciplinaEntity);
            response.put("message", "Professor associado a disciplina com sucesso!");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("error", "Erro ao associar professor!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterar(ProfessorDisciplinaDTO professorDisciplina){
        ProfessorDisciplinaEntity professorDisciplinaEntity = new ProfessorDisciplinaEntity(professorDisciplina);
        Map<String, String> response = new HashMap<>();
        try{
            professorDisciplinaRepository.save(professorDisciplinaEntity);
            response.put("message", "Associação alterada com sucesso!");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("error", "Erro ao alterar associação!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir(Long id){
        ProfessorDisciplinaEntity professorDisciplinaEntity = professorDisciplinaRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try{
            professorDisciplinaRepository.delete(professorDisciplinaEntity);
            response.put("message", "Associação excluída com sucesso!");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("error", "Erro ao excluir associação!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}
