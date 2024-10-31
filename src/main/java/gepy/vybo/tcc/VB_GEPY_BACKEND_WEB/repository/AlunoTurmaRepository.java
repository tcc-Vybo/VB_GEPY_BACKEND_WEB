package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.AlunoTurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoTurmaRepository extends JpaRepository<AlunoTurmaEntity, Long> {

    @Query(value = "SELECT apt.* FROM aluno_turma apt ORDER BY apt.id", nativeQuery = true)
    List<AlunoTurmaEntity> findAllOrderedById();

    @Query(value = "SELECT apt.* FROM aluno_turma apt JOIN aluno a ON apt.id_aluno = a.id JOIN turma t ON apt.id_turma = t.id WHERE t.id = ?", nativeQuery = true)
    List<AlunoTurmaEntity> findAlunoByTurma(Long idTurma);
}
