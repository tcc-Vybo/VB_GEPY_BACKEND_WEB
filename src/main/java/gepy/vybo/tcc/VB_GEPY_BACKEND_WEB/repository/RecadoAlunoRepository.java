package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.RecadoAlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecadoAlunoRepository extends JpaRepository<RecadoAlunoEntity, Long> {

    @Query(value = "SELECT * FROM recado_aluno ORDER BY id", nativeQuery = true)
    List<RecadoAlunoEntity> findAllOrderedById();

    @Query(value = "SELECT * FROM recado_aluno WHERE id_tiporecado = ?", nativeQuery = true)
    List<RecadoAlunoEntity> findAllByTipoRecado(Long idTipoRecado);

}
