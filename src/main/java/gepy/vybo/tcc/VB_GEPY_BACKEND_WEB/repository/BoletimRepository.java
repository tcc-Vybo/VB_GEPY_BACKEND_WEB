package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.BoletimEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoletimRepository extends JpaRepository<BoletimEntity, Long> {

    @Query(value = "SELECT * FROM boletim ORDER BY id", nativeQuery = true)
    List<BoletimEntity> findAllOrderedById();

    @Query(value = "SELECT * FROM boletim WHERE id_disciplina = ?", nativeQuery = true)
    List<BoletimEntity> findAllByDisciplina(Long idDisciplina);
}
