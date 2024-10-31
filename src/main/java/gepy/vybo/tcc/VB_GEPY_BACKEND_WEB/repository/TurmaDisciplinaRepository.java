package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.TurmaDisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TurmaDisciplinaRepository extends JpaRepository<TurmaDisciplinaEntity, Long> {

    @Query(value = "SELECT tpd.* FROM turma_disciplina tpd ORDER BY tpd.id", nativeQuery = true)
    List<TurmaDisciplinaEntity> findAllOrderedById();
}
