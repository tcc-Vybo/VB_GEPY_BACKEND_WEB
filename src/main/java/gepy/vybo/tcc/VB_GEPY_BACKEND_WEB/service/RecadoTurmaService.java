package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.RecadoTurmaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.RecadoTurmaEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.RecadoTurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RecadoTurmaService {

    @Autowired
    private RecadoTurmaRepository recadoTurmaRepository;

    public List<RecadoTurmaDTO> listarTodos(){
        List<RecadoTurmaEntity> recadoTurma = recadoTurmaRepository.findAllOrderedById();
        return recadoTurma.stream().map(RecadoTurmaDTO::new).toList();
    }

    public List<RecadoTurmaDTO> buscarPorTipoRecado(Long idTipoRecado){
        List<RecadoTurmaEntity> recadoTurmaPorTipo = recadoTurmaRepository.findAllByTipoRecado(idTipoRecado);
        return recadoTurmaPorTipo.stream().map(RecadoTurmaDTO::new).collect(Collectors.toList());
    }

    public List<RecadoTurmaDTO> buscarPorDestinatario(Long idDestinatario){
        List<RecadoTurmaEntity> recadoTurmaPorDestinatario = recadoTurmaRepository.findAllByDestinatario(idDestinatario);
        return recadoTurmaPorDestinatario.stream().map(RecadoTurmaDTO::new).collect(Collectors.toList());
    }

    public List<RecadoTurmaDTO> buscarPorRemetente(Long idRemetente){
        List<RecadoTurmaEntity> recadoTurmaPorRemetente = recadoTurmaRepository.findAllByRementente(idRemetente);
        return recadoTurmaPorRemetente.stream().map(RecadoTurmaDTO::new).collect(Collectors.toList());
    }

    public List<RecadoTurmaDTO> buscarPorStatus(String status){
        List<RecadoTurmaEntity> recadoTurmaPorStatus = recadoTurmaRepository.findAllByStatus(status);
        return recadoTurmaPorStatus.stream().map(RecadoTurmaDTO::new).collect(Collectors.toList());
    }

    public List<RecadoTurmaDTO> buscarPorData(String data){
        List<RecadoTurmaEntity> recadoTurmaPorData = recadoTurmaRepository.findAllByData(data);
        return recadoTurmaPorData.stream().map(RecadoTurmaDTO::new).collect(Collectors.toList());
    }

    public List<RecadoTurmaDTO> buscarPorDataDeEnvio(String dataDeEnvio){
        List<RecadoTurmaEntity> recadoTurmaPorData = recadoTurmaRepository.findAllByDataDeEnvio(dataDeEnvio);
        return recadoTurmaPorData.stream().map(RecadoTurmaDTO::new).collect(Collectors.toList());
    }

    public List<RecadoTurmaDTO> buscarPorFiltrosSQL(
            String dataMarcada,
            String dataDeEnvio,
            Long remetente,
            Long destinatario,
            Long tipoRecado) {
        List<RecadoTurmaEntity> recadoTurmaPorFiltrosSql = recadoTurmaRepository.buscarPorFiltrosSQL(
                dataMarcada,
                dataDeEnvio,
                remetente,
                destinatario,
                tipoRecado
        );

        // Chama o método do repository passando os parâmetros
        return recadoTurmaPorFiltrosSql.stream().map(RecadoTurmaDTO::new).collect(Collectors.toList());
    }

    public ResponseEntity<Map<String, String>> inserir(RecadoTurmaDTO recadoTurma){
        RecadoTurmaEntity recadoTurmaEntity = new RecadoTurmaEntity(recadoTurma);
        Map<String, String> response = new HashMap<>();
        try {
            recadoTurmaRepository.save(recadoTurmaEntity);
            response.put("message", "Recado postado com sucesso!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao inserir recado!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> alterar(RecadoTurmaDTO recadoTurma){
        RecadoTurmaEntity recadoTurmaEntity = new RecadoTurmaEntity(recadoTurma);
        Map<String, String> response = new HashMap<>();
        try{
            recadoTurmaRepository.save(recadoTurmaEntity);
            response.put("message", "Recado alterado com sucesso!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao alterar recado!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> excluir(Long id){
        RecadoTurmaEntity recadoTurmaEntity = recadoTurmaRepository.findById(id).get();
        Map<String, String> response = new HashMap<>();
        try {
            recadoTurmaRepository.delete(recadoTurmaEntity);
            response.put("message", "Recado excluido com sucesso!");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("error", "Erro ao excluir recado!" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
