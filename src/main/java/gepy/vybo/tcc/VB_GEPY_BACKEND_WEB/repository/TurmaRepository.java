package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.TurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TurmaRepository extends JpaRepository<TurmaEntity, Long> {
    @Query(value = "SELECT * FROM turma WHERE nome LIKE %?%", nativeQuery = true)
    List<TurmaEntity> findTurmaByName(String nome);
}
