package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.DisciplinaEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, Long> {

    @Query(value = "SELECT d.* FROM disciplina d ORDER BY d.id", nativeQuery = true)
    List<DisciplinaEntity> findAllOrderedById();

    @Query(value = "SELECT d.* FROM disciplina d WHERE d.nome LIKE %?% ORDER BY d.id", nativeQuery = true)
    List<DisciplinaEntity> findDisciplinaByNome(String nome);
}
