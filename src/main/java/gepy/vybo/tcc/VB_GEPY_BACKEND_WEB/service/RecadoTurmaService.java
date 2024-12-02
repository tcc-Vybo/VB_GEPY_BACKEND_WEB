package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.FuncionarioDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.RecadoTurmaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.*;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.RecadoTurmaRepository;
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

    public List<RecadoTurmaDTO> buscarPorFiltros(String dataMarcada, String dataDeEnvio, Long remetente, Long destinatario, Long tipoRecado) {
        List<RecadoTurmaEntity> recadoTurmaComFiltros = recadoTurmaRepository.buscarPorFiltrosSQL(dataMarcada, dataDeEnvio, remetente, destinatario, tipoRecado);
        return recadoTurmaComFiltros.stream().map(RecadoTurmaDTO::new).collect(Collectors.toList());
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

    public ResponseEntity<Map<String, String>> alterValue(RecadoTurmaDTO recadoTurma, Long id) {
        Map<String, String> response = new HashMap<>();
        Optional<RecadoTurmaEntity> recadoTurmaEntityOptional = recadoTurmaRepository.findById(id);

        try {
            if (recadoTurmaEntityOptional.isPresent()) {
                RecadoTurmaEntity recadoTurmaEntity = recadoTurmaEntityOptional.get();

                // Log dos dados recebidos
                System.out.println("Recado recebido para alteração: " + recadoTurma.toString());

                // Validações básicas
                if (recadoTurma.getTitulo() == null || recadoTurma.getDescricao() == null ||
                        recadoTurma.getData() == null || recadoTurma.getHora() == null ||
                        recadoTurma.getRemetente() == null || recadoTurma.getDestinatario() == null ||
                        recadoTurma.getTipoRecado() == null) {
                    response.put("error", "Campos obrigatórios não podem ser nulos.");
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
                }

                // Atualiza os valores
                recadoTurmaEntity.setTitulo(recadoTurma.getTitulo());
                recadoTurmaEntity.setDescricao(recadoTurma.getDescricao());
                recadoTurmaEntity.setData(recadoTurma.getData());
                recadoTurmaEntity.setHora(recadoTurma.getHora());
                recadoTurmaEntity.setRemetente(new FuncionarioEntity(recadoTurma.getRemetente()));
                recadoTurmaEntity.setDestinatario(new TurmaEntity(recadoTurma.getDestinatario()));
                recadoTurmaEntity.setStatus(recadoTurma.getStatus());
                recadoTurmaEntity.setTipoRecado(new TipoRecadoEntity(recadoTurma.getTipoRecado()));

                recadoTurmaRepository.save(recadoTurmaEntity);

                response.put("message", "Recado alterado com sucesso!");
                return ResponseEntity.ok(response);
            } else {
                response.put("error", "Recado não encontrado!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            response.put("error", "Erro ao alterar recado: " + e.getMessage());
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
