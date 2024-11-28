package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.FuncionarioDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.TurmaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.CargoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.FuncionarioEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.TurmaEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public List<TurmaDTO> listarTodos(){
        List<TurmaEntity> turma = turmaRepository.findAllOrderedById();
        return turma.stream().map(TurmaDTO::new).toList();
    }

    public List<TurmaDTO> buscarPorNome(String nome){
        List<TurmaEntity> turmas = turmaRepository.findTurmaByName(nome);
        return turmas.stream().map(TurmaDTO::new).collect(Collectors.toList());
    }

    public ResponseEntity<Map<String, String>> inserir(TurmaDTO turma){
        TurmaEntity turmaEntity = new TurmaEntity(turma);
        Map<String, String> response = new HashMap<>();
        try {
            turmaRepository.save(turmaEntity);
            response.put("message", "Turma cadastrada com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao cadastrar turma!!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterar(TurmaDTO turma){
        TurmaEntity turmaEntity = new TurmaEntity(turma);
        Map<String, String> response = new HashMap<>();
        try{
            turmaRepository.save(turmaEntity);
            response.put("message", "Turma alterada com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao alterar turma!!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterValue(TurmaDTO turma, Long id) {
        Map<String, String> response = new HashMap<>();
        Optional<TurmaEntity> turmaEntityOptional = turmaRepository.findById(id);

        try {
            if (turmaEntityOptional.isPresent()) {
                TurmaEntity turmaEntity = turmaEntityOptional.get();
                turmaEntity.setNome(turma.getNome());

                turmaRepository.save(turmaEntity);

                // Mensagem de resposta
                response.put("message", "Turma alterada com sucesso!!");
                return ResponseEntity.ok(response);
            } else {
                response.put("error", "Turma não encontrada!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            // Mensagem de erro genérica
            response.put("error", "Erro ao alterar turma: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir(Long id){
        TurmaEntity turma = turmaRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try {
            turmaRepository.delete(turma);
            response.put("message", "Turma removida com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao remover turma!!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
