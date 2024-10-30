package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.AlunoTurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoTurmaRepository extends JpaRepository<AlunoTurmaEntity, Long> {

    @Query(value = "SELECT * FROM aluno_turma ORDER BY id", nativeQuery = true)
    List<AlunoTurmaEntity> findAllOrderedById();
}
