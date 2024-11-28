package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.DisciplinaEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.FuncionarioEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.ProfessorDisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfessorDisciplinaRepository extends JpaRepository<ProfessorDisciplinaEntity, Long> {

    @Query(value = "SELECT ppd.* FROM professor_disciplina ppd ORDER BY ppd.id", nativeQuery = true)
    List<ProfessorDisciplinaEntity> findAllOrderedById();

    @Query(value = "SELECT ppd.* FROM professor_disciplina ppd JOIN funcionario p ON ppd.id_professor = p.id JOIN disciplina d ON ppd.id_disciplina = d.id WHERE d.id = ?", nativeQuery = true)
    List<ProfessorDisciplinaEntity> findProfessorByDisciplina(Long idDisciplina);

    boolean existsByProfessorAndDisciplina(FuncionarioEntity professor, DisciplinaEntity disciplina);
}
