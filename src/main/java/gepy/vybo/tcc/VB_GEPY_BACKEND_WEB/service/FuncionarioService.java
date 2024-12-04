package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.FuncionarioDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.*;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.FuncionarioRepository;
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
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioDTO> ListarTodos(){
        List<FuncionarioEntity> funcionarios = funcionarioRepository.findAllOrderedById();
        return funcionarios.stream().map(FuncionarioDTO::new).toList();
    }

    public List<FuncionarioDTO> buscarPorNome(String nomeCompleto) {
        List<FuncionarioEntity> funcionarios = funcionarioRepository.findFuncionarioByName(nomeCompleto);
        return funcionarios.stream().map(FuncionarioDTO::new)
                .collect(Collectors.toList());
    }

    public FuncionarioDTO buscarPorCpfEmail(String cpf, String email) {
        FuncionarioEntity funcionario = funcionarioRepository.findByCpfAndEmail(cpf, email);
        return new FuncionarioDTO(funcionario);
    }

    public ResponseEntity<Map<String, String>> inserir(FuncionarioDTO funcionario){
        FuncionarioEntity funcionarioEntity = new FuncionarioEntity(funcionario);
        Map<String, String> response = new HashMap<>();
        try{
            funcionarioRepository.save(funcionarioEntity);
            response.put("message", "Funcionário cadastado com sucesso!!");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("error", "Erro ao cadastrar funcionário!!" + e.getMessage());
            return ResponseEntity.ok(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterar(FuncionarioDTO funcionario){
        FuncionarioEntity funcionarioEntity = new FuncionarioEntity(funcionario);
        Map<String, String> response = new HashMap<>();
        try{
            funcionarioRepository.save(funcionarioEntity);
            response.put("message", "Funcionário alterado com sucesso!!");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("error", "Erro ao alterar funcionário!!" + e.getMessage());
            return ResponseEntity.ok(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterValue(FuncionarioDTO funcionario, Long id) {
        Map<String, String> response = new HashMap<>();
        Optional<FuncionarioEntity> funcionarioEntityOptional = funcionarioRepository.findById(id);

        try {
            if (funcionarioEntityOptional.isPresent()) {
                FuncionarioEntity funcionarioEntity = funcionarioEntityOptional.get();
                funcionarioEntity.setNomeCompleto(funcionario.getNomeCompleto());
                funcionarioEntity.setDataNascimento(funcionario.getDataNascimento());
                funcionarioEntity.setCidadeNascimento(funcionario.getCidadeNascimento());
                funcionarioEntity.setUfNascimento(funcionario.getUfNascimento());
                funcionarioEntity.setNacionalidade(funcionario.getNacionalidade());
                funcionarioEntity.setGenero(funcionario.getGenero());
                funcionarioEntity.setCorRaca(funcionario.getCorRaca());
                funcionarioEntity.setTelefone(funcionario.getTelefone());
                funcionarioEntity.setEmail(funcionario.getEmail());

                funcionarioEntity.setCep(funcionario.getCep());
                funcionarioEntity.setEndereco(funcionario.getEndereco());
                funcionarioEntity.setNumero(funcionario.getNumero());
                funcionarioEntity.setComplemento(funcionario.getComplemento());
                funcionarioEntity.setCidade(funcionario.getCidade());
                funcionarioEntity.setBairro(funcionario.getBairro());
                funcionarioEntity.setUf(funcionario.getUf());

                funcionarioEntity.setNumeroRegistro(funcionario.getNumeroRegistro());
                funcionarioEntity.setCpf(funcionario.getCpf());
                funcionarioEntity.setDataEmissao(funcionario.getDataEmissao());
                funcionarioEntity.setOrgaoExpedidor(funcionario.getOrgaoExpedidor());

                funcionarioRepository.save(funcionarioEntity);

                // Mensagem de resposta
                response.put("message", "Funcionário alterado com sucesso!!");
                return ResponseEntity.ok(response);
            } else {
                response.put("error", "Funcionário não encontrado!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            // Mensagem de erro genérica
            response.put("error", "Erro ao alterar funcionário: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir(Long id){
        FuncionarioEntity funcionario= funcionarioRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try {
            funcionarioRepository.delete(funcionario);
            response.put("message", "Funcionário deletado com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao deletar funcionário!!" + e.getMessage());
            return ResponseEntity.ok(response);
        }
    }










































}
