package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.TipoRecadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoRecadoRepository extends JpaRepository<TipoRecadoEntity, Long> {

    @Query(value = "SELECT tp.* FROM tipo_recado tp ORDER BY tp.id", nativeQuery = true)
    List<TipoRecadoEntity> findAllOrderedById();
}
