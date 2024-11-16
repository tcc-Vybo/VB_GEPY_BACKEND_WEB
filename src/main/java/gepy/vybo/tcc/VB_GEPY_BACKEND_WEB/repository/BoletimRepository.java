package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.BoletimEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoletimRepository extends JpaRepository<BoletimEntity, Long> {

    @Query(value = "SELECT b.* FROM boletim b ORDER BY b.id", nativeQuery = true)
    List<BoletimEntity> findAllOrderedById();

    @Query(value = "SELECT b.* FROM boletim b WHERE b.id_disciplina = ?", nativeQuery = true)
    List<BoletimEntity> findAllByDisciplina(Long idDisciplina);

    @Query(value = "SELECT b.* FROM boletim b WHERE b.id_aluno = :idAluno", nativeQuery = true)
    List<BoletimEntity> findAllByAluno(@Param("idAluno") Long idAluno);
}
