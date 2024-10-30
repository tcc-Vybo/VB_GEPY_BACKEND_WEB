package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {

    @Query(value = "SELECT * FROM funcionario ORDER BY id", nativeQuery = true)
    List<FuncionarioEntity> findAllOrderedById();
    @Query(value = "SELECT * FROM funcionario WHERE nome_completo LIKE %?% ORDER BY id", nativeQuery = true)
    List<FuncionarioEntity> findFuncionarioByName(String nomeCompleto);
    @Query(value = "SELECT * FROM funcionario WHERE cpf = ? and email = ?", nativeQuery = true)
    FuncionarioEntity findByCpfAndEmail(String cpf, String email);
}
