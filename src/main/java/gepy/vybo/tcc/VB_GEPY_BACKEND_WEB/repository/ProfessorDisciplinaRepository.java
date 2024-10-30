package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.ProfessorDisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfessorDisciplinaRepository extends JpaRepository<ProfessorDisciplinaEntity, Long> {

    @Query(value = "SELECT * FROM professor_disciplina ORDER BY id", nativeQuery = true)
    List<ProfessorDisciplinaEntity> findAllOrderedById();
}
