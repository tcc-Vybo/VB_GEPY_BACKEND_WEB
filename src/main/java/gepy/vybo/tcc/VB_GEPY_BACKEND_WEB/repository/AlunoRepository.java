package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.AlunoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {

    @Query(value = "SELECT a.* FROM aluno a ORDER BY a.id", nativeQuery = true)
    List<AlunoEntity> findAllOrderedById();

    @Query(value = "SELECT a.* FROM aluno a WHERE a.nome_completo LIKE %?% ORDER BY a.id", nativeQuery = true)
    List<AlunoEntity> findAlunoByName(String nomeCompleto);

    @Query(value = "SELECT a.* FROM aluno a WHERE a.cpf = ? and a.email_aluno = ?", nativeQuery = true)
    AlunoEntity findByCpfAndEmail(String cpf, String email);
}
