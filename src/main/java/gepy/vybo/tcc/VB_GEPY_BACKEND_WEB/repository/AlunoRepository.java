package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.AlunoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {

    @Query(value = "SELECT * FROM aluno ORDER BY id", nativeQuery = true)
    List<AlunoEntity> findAllOrderedById();

    @Query(value = "SELECT * FROM aluno WHERE nome_completo LIKE %?% ORDER BY id", nativeQuery = true)
    List<AlunoEntity> findAlunoByName(String nomeCompleto);
}
