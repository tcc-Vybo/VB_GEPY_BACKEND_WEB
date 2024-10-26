package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.AlunoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.RecadoAlunoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.RecadoTurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecadoTurmaRepository extends JpaRepository<RecadoTurmaEntity, Long> {

    @Query(value = "SELECT * FROM recado_turma ORDER BY id", nativeQuery = true)
    List<RecadoTurmaEntity> findAllOrderedById();

    @Query(value = "SELECT * FROM recado_turma WHERE id_tiporecado = ?", nativeQuery = true)
    List<RecadoTurmaEntity> findAllByTipoRecado(Long idTipoRecado);
}
