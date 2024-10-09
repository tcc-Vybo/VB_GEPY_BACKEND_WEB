package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.BoletimDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.BoletimEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.BoletimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletimService {

    @Autowired
    private BoletimRepository boletimRepository;

    public List<BoletimDTO> listarTodos(){
        List<BoletimEntity> boletim = boletimRepository.findAll();
        return boletim.stream().map(BoletimDTO::new).toList();
    }

    public void inserir(BoletimDTO boletim){
        BoletimEntity boletimEntity = new BoletimEntity(boletim);
        boletimRepository.save(boletimEntity);
    }

    public BoletimDTO alterar(BoletimDTO boletim){
        BoletimEntity boletimEntity = new BoletimEntity(boletim);
        return new BoletimDTO(boletimRepository.save(boletimEntity));
    }

    public void excluir(Long id){
        BoletimEntity boletimEntity = boletimRepository.findById(id).get();
        boletimRepository.delete(boletimEntity);
    }
}
