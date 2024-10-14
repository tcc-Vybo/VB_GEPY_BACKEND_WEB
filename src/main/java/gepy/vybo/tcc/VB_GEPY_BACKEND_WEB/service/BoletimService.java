package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.BoletimDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.BoletimEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.BoletimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoletimService {

    @Autowired
    private BoletimRepository boletimRepository;

    public List<BoletimDTO> listarTodos(){
        List<BoletimEntity> boletim = boletimRepository.findAllOrderedById();
        return boletim.stream().map(BoletimDTO::new).toList();
    }

    public ResponseEntity<Map<String, String>> inserir(BoletimDTO boletim){
        BoletimEntity boletimEntity = new BoletimEntity(boletim);
        Map<String, String> response = new HashMap<>();
        try {
            boletimRepository.save(boletimEntity);
            response.put("message", "Boletim registrado com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao registrar boletim!!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterar(BoletimDTO boletim){
        BoletimEntity boletimEntity = new BoletimEntity(boletim);
        Map<String, String> response = new HashMap<>();
        try{
            boletimRepository.save(boletimEntity);
            response.put("message", "Boletim alterado com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao alterar boletim!!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir(Long id){
        BoletimEntity boletimEntity = boletimRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try {
            boletimRepository.delete(boletimEntity);
            response.put("message", "Boletim excluido com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao excluir boletim!!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
