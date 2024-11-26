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

    public BoletimDTO findById(Long id) {
        Optional<BoletimEntity> boletim = boletimRepository.findById(id);
        return boletim.map(BoletimDTO::new).orElse(null);
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

    public ResponseEntity<Map<String, String>> alterValue(BoletimDTO boletim, Long id) {
        Map<String, String> response = new HashMap<>();
        Optional<BoletimEntity> boletimEntityOptional = boletimRepository.findById(id);

        try {
            if (boletimEntityOptional.isPresent()) {
                BoletimEntity boletimEntity = boletimEntityOptional.get();
                boletimEntity.setAluno(new AlunoEntity(boletim.getAluno()));
                boletimEntity.setDisciplina(new DisciplinaEntity(boletim.getDisciplina()));
                boletimEntity.setNotaPrimeiroBim(boletim.getNotaPrimeiroBim());
                boletimEntity.setFaltaPrimeiroBim(boletim.getFaltaPrimeiroBim());
                boletimEntity.setNotaSegundoBim(boletim.getNotaSegundoBim());
                boletimEntity.setFaltaSegundoBim(boletim.getFaltaSegundoBim());
                boletimEntity.setNotaTerceiroBim(boletim.getNotaTerceiroBim());
                boletimEntity.setFaltaTerceiroBim(boletim.getFaltaTerceiroBim());
                boletimEntity.setNotaQuartoBim(boletim.getNotaQuartoBim());
                boletimEntity.setFaltaQuartoBim(boletim.getFaltaQuartoBim());
                boletimEntity.setSituacao(new SituacaoEntity(boletim.getSituacao()));

                boletimRepository.save(boletimEntity);

                // Mensagem de resposta
                response.put("message", "Boletim alterado com sucesso!!");
                return ResponseEntity.ok(response);
            } else {
                response.put("error", "Boletim não encontrado!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            // Mensagem de erro genérica
            response.put("error", "Erro ao alterar boletim: " + e.getMessage());
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
            response.put("error", "Erro ao excluir boletim!!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
