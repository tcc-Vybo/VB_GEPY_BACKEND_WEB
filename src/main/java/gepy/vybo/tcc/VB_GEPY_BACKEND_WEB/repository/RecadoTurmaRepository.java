package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.RecadoTurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecadoTurmaRepository extends JpaRepository<RecadoTurmaEntity, Long> {

    @Query(value = "SELECT rt.* FROM recado_turma rt ORDER BY rt.id", nativeQuery = true)
    List<RecadoTurmaEntity> findAllOrderedById();

    @Query(value = "SELECT rt.* FROM recado_turma rt WHERE rt.id_tiporecado = ?", nativeQuery = true)
    List<RecadoTurmaEntity> findAllByTipoRecado(Long idTipoRecado);

    @Query(value = "SELECT rt.* FROM recado_turma rt JOIN turma t ON rt.id_turma = t.id WHERE t.id = ?", nativeQuery = true)
    List<RecadoTurmaEntity> findAllByDestinatario(Long idDestinatario);

    @Query(value = "SELECT rt.* FROM recado_turma rt JOIN funcionario f ON rt.id_funcionario = f.id WHERE f.id = ?", nativeQuery = true)
    List<RecadoTurmaEntity> findAllByRementente(Long idRemetente);

    @Query(value = "SELECT rt.* FROM recado_turma rt WHERE rt.status LIKE %?% ORDER BY id", nativeQuery = true)
    List<RecadoTurmaEntity> findAllByStatus(String status);

    @Query(value = "SELECT rt.* FROM recado_turma rt WHERE rt.data LIKE %?% ORDER BY id", nativeQuery = true)
    List<RecadoTurmaEntity> findAllByData(String data);

    @Query(value = "SELECT rt.* FROM recado_turma rt WHERE rt.data_de_envio LIKE %?% ORDER BY id", nativeQuery = true)
    List<RecadoTurmaEntity> findAllByDataDeEnvio(String dataDeEnvio);

    @Query(value = "SELECT * FROM recado_turma rt " +
            "WHERE (:dataMarcada IS NULL OR rt.data ILIKE CONCAT('%', :dataMarcada, '%'))" +
            "AND (:dataDeEnvio IS NULL OR rt.data_de_envio ILIKE CONCAT('%', :dataDeEnvio,'%'))" +
            "AND (:remetente IS NULL OR rt.id_funcionario = :remetente)" +
            "AND (:destinatario IS NULL OR rt.id_turma = :destinatario)" +
            "AND (:tipoRecado IS NULL OR rt.id_tiporecado = :tipoRecado);",
            nativeQuery = true)
    List<RecadoTurmaEntity> buscarPorFiltrosSQL(
            @Param("dataMarcada") String dataMarcada,
            @Param("dataDeEnvio") String dataDeEnvio,
            @Param("remetente") Long remetente,
            @Param("destinatario") Long destinatario,
            @Param("tipoRecado") Long tipoRecado);

}
