package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.AlunoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.AlunoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoDTO> buscarPorNome(String nomeCompleto) {
        List<AlunoEntity> alunos = alunoRepository.findAlunoByName(nomeCompleto);

        // Converter entidades para DTOs
        return alunos.stream().map(AlunoDTO::new)
                .collect(Collectors.toList());
    }

    public List<AlunoDTO> ListarTodos(){
        List<AlunoEntity> aluno = alunoRepository.findAllOrderedById();
        return aluno.stream().map(AlunoDTO::new).toList();
    }


    public ResponseEntity<Map<String, String>> inserir(AlunoDTO aluno) {
        AlunoEntity alunoEntity = new AlunoEntity(aluno);
        Map<String, String> response = new HashMap<>();
        try {
            alunoRepository.save(alunoEntity);
            response.put("message", "Aluno cadastrado com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao cadastrar aluno!!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterar(AlunoDTO aluno) {
        AlunoEntity alunoEntity = new AlunoEntity(aluno);
        Map<String, String> response = new HashMap<>();
        try {
            alunoRepository.save(alunoEntity);
            response.put("message", "Aluno alterado com sucesso!!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "Erro ao alterar aluno!!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir (Long id){
        AlunoEntity aluno = alunoRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try {
            alunoRepository.delete(aluno);
            response.put("message", "Aluno removido com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao remover aluno!!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

};