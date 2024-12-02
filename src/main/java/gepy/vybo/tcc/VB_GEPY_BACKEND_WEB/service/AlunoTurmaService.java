package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.AlunoTurmaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.AlunoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.AlunoTurmaEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.TurmaEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.AlunoTurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AlunoTurmaService {

    @Autowired
    private AlunoTurmaRepository alunoTurmaRepository;

    public List<AlunoTurmaDTO> listarTodos(){
        List<AlunoTurmaEntity> alunoTurma = alunoTurmaRepository.findAllOrderedById();
        return alunoTurma.stream().map(AlunoTurmaDTO::new).toList();
    }

    public List<AlunoTurmaDTO> buscarPorTurma(Long idTurma){
        List<AlunoTurmaEntity> alunoTurmas = alunoTurmaRepository.findAlunoByTurma(idTurma);
        return alunoTurmas.stream().map(AlunoTurmaDTO::new).collect(Collectors.toList());
    }

    public List<AlunoTurmaDTO> buscarPorAluno(Long idAluno){
        List<AlunoTurmaEntity> alunoTurmas = alunoTurmaRepository.findVinculoAlunoByTurma(idAluno);
        return alunoTurmas.stream().map(AlunoTurmaDTO::new).collect(Collectors.toList());
    }

    public ResponseEntity<Map<String, String>> inserir(AlunoTurmaDTO alunoTurma){
        AlunoEntity alunoEntity = new AlunoEntity(alunoTurma.getAluno());
        TurmaEntity turmaEntity = new TurmaEntity(alunoTurma.getTurma());

        AlunoTurmaEntity alunoTurmaEntity = new AlunoTurmaEntity(alunoTurma);
        Map<String, String> response = new HashMap<>();
        try{
            if(alunoTurmaRepository.existsByAlunoAndTurma(alunoEntity, turmaEntity)){
                throw new IllegalArgumentException("O aluno já está vinculado a turma!");
            }
            alunoTurmaRepository.save(alunoTurmaEntity);
            response.put("message", "Aluno associado a turma com sucesso!");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("error", "Erro ao associar aluno!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterar(AlunoTurmaDTO alunoTurma){
        AlunoTurmaEntity alunoTurmaEntity = new AlunoTurmaEntity(alunoTurma);
        Map<String, String> response = new HashMap<>();
        try{
            alunoTurmaRepository.save(alunoTurmaEntity);
            response.put("message", "Associação alterada com sucesso!");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("error", "Erro ao alterar associação!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir(Long id){
        AlunoTurmaEntity alunoTurmaEntity = alunoTurmaRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try{
            alunoTurmaRepository.delete(alunoTurmaEntity);
            response.put("message", "Associação removida com sucesso!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao remover associação!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
