package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.BoletimDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.AlunoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.BoletimEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.DisciplinaEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.SituacaoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.BoletimRepository;
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
public class BoletimService {

    @Autowired
    private BoletimRepository boletimRepository;

    public List<BoletimDTO> listarTodos(){
        List<BoletimEntity> boletim = boletimRepository.findAllOrderedById();
        return boletim.stream().map(BoletimDTO::new).toList();
    }

    public List<BoletimDTO> buscarPorDisciplina(Long idDisciplina){
        List<BoletimEntity> notas = boletimRepository.findAllByDisciplina(idDisciplina);
        return notas.stream().map(BoletimDTO::new).collect(Collectors.toList());
    }

    public List<BoletimDTO> buscarPorAluno(Long idAluno){
        List<BoletimEntity> notas = boletimRepository.findAllByAluno(idAluno);
        return notas.stream().map(BoletimDTO::new).collect(Collectors.toList());
    }

    public ResponseEntity<Map<String, String>> inserir(BoletimDTO boletim){
        BoletimEntity boletimEntity = new BoletimEntity(boletim);
        Map<String, String> response = new HashMap<>();
        try {
            boletimRepository.save(boletimEntity);
            response.put("message", "Boletim registrado com sucesso!!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao registrar boletim!!" + e.getMessage());
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
            response.put("error", "Erro ao alterar boletim!!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> atualizar(Long id, BoletimDTO boletimDTO){
        Optional<BoletimEntity> boletimOpt = boletimRepository.findById(id);
        Map<String, String> response = new HashMap<>();
        try {
            if (boletimOpt.isPresent()) {
                BoletimEntity boletimEntity = boletimOpt.get();
                if (boletimDTO.getNotaPrimeiroBim() != 0) {
                    boletimEntity.setNotaPrimeiroBim(boletimDTO.getNotaPrimeiroBim());
                }
                if (boletimDTO.getFaltaPrimeiroBim() != 0) {
                    boletimEntity.setFaltaPrimeiroBim(boletimDTO.getFaltaPrimeiroBim());
                }
                if (boletimDTO.getNotaSegundoBim() != 0) {
                    boletimEntity.setNotaSegundoBim(boletimDTO.getNotaSegundoBim());
                }
                if (boletimDTO.getFaltaSegundoBim() != 0) {
                    boletimEntity.setFaltaSegundoBim(boletimDTO.getFaltaSegundoBim());
                }
                if (boletimDTO.getNotaTerceiroBim() != 0) {
                    boletimEntity.setNotaTerceiroBim(boletimDTO.getNotaTerceiroBim());
                }
                if (boletimDTO.getFaltaTerceiroBim() != 0) {
                    boletimEntity.setFaltaTerceiroBim(boletimDTO.getFaltaTerceiroBim());
                }
                if (boletimDTO.getNotaQuartoBim() != 0) {
                    boletimEntity.setNotaQuartoBim(boletimDTO.getNotaQuartoBim());
                }
                if (boletimDTO.getFaltaQuartoBim() != 0) {
                    boletimEntity.setFaltaQuartoBim(boletimDTO.getFaltaQuartoBim());
                }
                if (boletimDTO.getSituacao() != null) {
                    boletimEntity.setSituacao(new SituacaoEntity(boletimDTO.getSituacao()));
                }
                if (boletimDTO.getAluno() != null) {
                    boletimEntity.setAluno(new AlunoEntity(boletimDTO.getAluno()));
                }
                if (boletimDTO.getDisciplina() != null) {
                    boletimEntity.setDisciplina(new DisciplinaEntity(boletimDTO.getDisciplina()));
                }
                boletimRepository.save(boletimEntity);
            }
            response.put("message", "Boletim atualizado com sucesso!!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "Erro ao atualizar boletim!!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
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
            response.put("error", "Erro ao excluir boletim!!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
