package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.RecadoTurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecadoTurmaRepository extends JpaRepository<RecadoTurmaEntity, Long> {

    @Query(value = "SELECT rt.* FROM recado_turma rt ORDER BY rt.id", nativeQuery = true)
    List<RecadoTurmaEntity> findAllOrderedById();

    @Query(value = "SELECT rt.* FROM recado_turma rt WHERE rt.id_tiporecado = ?", nativeQuery = true)
    List<RecadoTurmaEntity> findAllByTipoRecado(Long idTipoRecado);

    @Query(value = "SELECT rt.* FROM recado_turma rt JOIN funcionario f ON rt.id_funcionario = f.id WHERE f.id = ?", nativeQuery = true)
    List<RecadoTurmaEntity> findAllByDestinatario(Long idDestinatario);

    @Query(value = "SELECT rt.* FROM recado_turma rt JOIN turma t ON rt.id_aluno = t.id WHERE t.id = ?", nativeQuery = true)
    List<RecadoTurmaEntity> findAllByRementente(Long idRemetente);

    @Query(value = "SELECT rt.* FROM recado_turma rt WHERE rt.status LIKE %?% ORDER BY id", nativeQuery = true)
    List<RecadoTurmaEntity> findAllByStatus(String status);

    @Query(value = "SELECT rt.* FROM recado_turma rt WHERE rt.data LIKE %?% ORDER BY id", nativeQuery = true)
    List<RecadoTurmaEntity> findAllByData(String data);

    @Query(value = "SELECT rt.* FROM recado_turma rt WHERE rt.data_de_envio LIKE %?% ORDER BY id", nativeQuery = true)
    List<RecadoTurmaEntity> findAllByDataDeEnvio(String dataDeEnvio);

}
