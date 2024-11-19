package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.SituacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SituacaoRepository extends JpaRepository<SituacaoEntity, Long> {

    @Query(value = "SELECT s.* FROM situacao s ORDER BY s.id", nativeQuery = true)
    List<SituacaoEntity> findAllOrderedById();
}
