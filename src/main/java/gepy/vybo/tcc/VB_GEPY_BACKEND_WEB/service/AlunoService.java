package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.AlunoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.BoletimDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.AlunoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.BoletimEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.DisciplinaEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.SituacaoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.AlunoRepository;
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

    public AlunoDTO buscaPorCpfEmail(String cpf, String email){
        AlunoEntity aluno = alunoRepository.findByCpfAndEmail(cpf, email);
        return new AlunoDTO(aluno);
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

    public ResponseEntity<Map<String, String>> alterValue(AlunoDTO aluno, Long id) {
        Map<String, String> response = new HashMap<>();
        Optional<AlunoEntity> alunoEntityOptional = alunoRepository.findById(id);

        try {
            if (alunoEntityOptional.isPresent()) {
                AlunoEntity alunoEntity = alunoEntityOptional.get();
                alunoEntity.setNomeCompleto(aluno.getNomeCompleto());
                alunoEntity.setDataNascimento(aluno.getDataNascimento());
                alunoEntity.setCidadeNascimento(aluno.getCidadeNascimento());
                alunoEntity.setUfNascimento(aluno.getUfNascimento());
                alunoEntity.setNacionalidade(aluno.getNacionalidade());
                alunoEntity.setGenero(aluno.getGenero());
                alunoEntity.setCorRaca(aluno.getCorRaca());
                alunoEntity.setNecessidades(aluno.getNecessidades());

                alunoEntity.setCep(aluno.getCep());
                alunoEntity.setEndereco(aluno.getEndereco());
                alunoEntity.setNumeroEndereco(aluno.getNumeroEndereco());
                alunoEntity.setComplemento(aluno.getComplemento());
                alunoEntity.setBairro(aluno.getBairro());
                alunoEntity.setMunicipio(aluno.getMunicipio());
                alunoEntity.setUf(aluno.getUf());

                alunoEntity.setNumeroRegistro(aluno.getNumeroRegistro());
                alunoEntity.setCpf(aluno.getCpf());
                alunoEntity.setDataEmissao(aluno.getDataEmissao());
                alunoEntity.setOrgaoExpedidor(aluno.getOrgaoExpedidor());

                alunoEntity.setEmailAluno(aluno.getEmailAluno());
                alunoEntity.setTelefoneAluno(aluno.getTelefoneAluno());

                alunoEntity.setNomeResponsavel(aluno.getNomeResponsavel());
                alunoEntity.setCpfResponsavel(aluno.getCpfResponsavel());
                alunoEntity.setRelacao(aluno.getRelacao());
                alunoEntity.setTelefoneResponsavel(aluno.getTelefoneResponsavel());
                alunoEntity.setEmailResponsavel(aluno.getEmailResponsavel());
                alunoRepository.save(alunoEntity);

                // Mensagem de resposta
                response.put("message", "Aluno alterado com sucesso!!");
                return ResponseEntity.ok(response);
            } else {
                response.put("error", "Aluno não encontrado!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            // Mensagem de erro genérica
            response.put("error", "Erro ao alterar aluno: " + e.getMessage());
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