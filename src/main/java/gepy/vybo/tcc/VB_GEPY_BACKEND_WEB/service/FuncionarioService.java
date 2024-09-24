package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.FuncionarioDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.FuncionarioEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioDTO> ListarTodos(){
        List<FuncionarioEntity> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream().map(FuncionarioDTO::new).toList();
    }

    public List<FuncionarioDTO> buscarPorNome(String nomeCompleto) {
        List<FuncionarioEntity> funcionarios = funcionarioRepository.findFuncionarioByName(nomeCompleto);
        return funcionarios.stream().map(FuncionarioDTO::new)
                .collect(Collectors.toList());
    }

    public void inserir(FuncionarioDTO funcionario){
        FuncionarioEntity funcionarioEntity = new FuncionarioEntity(funcionario);
        funcionarioRepository.save(funcionarioEntity);
    }

    public FuncionarioDTO alterar(FuncionarioDTO funcionario){
        FuncionarioEntity funcionarioEntity = new FuncionarioEntity(funcionario);
        return new FuncionarioDTO(funcionarioRepository.save(funcionarioEntity));
    }

    public void excluir(Long id){
        FuncionarioEntity funcionario= funcionarioRepository.findById(id).get();
        funcionarioRepository.delete(funcionario);
    }

    public FuncionarioDTO buscarPorId(Long id){
        return new FuncionarioDTO((funcionarioRepository.findById(id).get()));
    }










































}
