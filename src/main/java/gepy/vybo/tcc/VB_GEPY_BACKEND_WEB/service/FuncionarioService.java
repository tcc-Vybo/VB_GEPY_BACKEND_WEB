package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.FuncionarioDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.FuncionarioEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        FuncionarioEntity funcionario = funcionarioRepository.findByEmailAndCpf(cpf, email);
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
            response.put("error", "Erro ao cadastrar funcionário!!");
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
            response.put("error", "Erro ao alterar funcionário!!");
            return ResponseEntity.ok(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir(Long id){
        FuncionarioEntity funcionario= funcionarioRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try {
            funcionarioRepository.deleteById(id);
            response.put("message", "Funcionário deletado com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao deletar funcionário!!");
            return ResponseEntity.ok(response);
        }
    }










































}
