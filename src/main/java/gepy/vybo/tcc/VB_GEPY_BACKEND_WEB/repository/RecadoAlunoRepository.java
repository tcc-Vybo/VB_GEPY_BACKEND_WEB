package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.RecadoAlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecadoAlunoRepository extends JpaRepository<RecadoAlunoEntity, Long> {

    @Query(value = "SELECT ra.* FROM recado_aluno ra ORDER BY ra.id", nativeQuery = true)
    List<RecadoAlunoEntity> findAllOrderedById();

    @Query(value = "SELECT ra.* FROM recado_aluno ra WHERE ra.id_tiporecado = ?", nativeQuery = true)
    List<RecadoAlunoEntity> findAllByTipoRecado(Long idTipoRecado);

    @Query(value = "SELECT ra.* FROM recado_aluno ra JOIN funcionario f ON ra.id_funcionario = f.id WHERE f.id = ?", nativeQuery = true)
    List<RecadoAlunoEntity> findAllByDestinatario(Long idDestinatario);

    @Query(value = "SELECT ra.* FROM recado_aluno ra JOIN aluno a ON ra.id_aluno = a.id WHERE a.id = ?", nativeQuery = true)
    List<RecadoAlunoEntity> findAllByRementente(Long idRemetente);

    @Query(value = "SELECT ra.* FROM recado_aluno ra WHERE ra.status LIKE %?% ORDER BY id", nativeQuery = true)
    List<RecadoAlunoEntity> findAllByStatus(String status);

    @Query(value = "SELECT ra.* FROM recado_aluno ra WHERE ra.data LIKE %?% ORDER BY id", nativeQuery = true)
    List<RecadoAlunoEntity> findAllByData(String data);

    @Query(value = "SELECT ra.* FROM recado_aluno ra WHERE ra.data_de_envio LIKE %?% ORDER BY id", nativeQuery = true)
    List<RecadoAlunoEntity> findAllByDataDeEnvio(String dataDeEnvio);

}
