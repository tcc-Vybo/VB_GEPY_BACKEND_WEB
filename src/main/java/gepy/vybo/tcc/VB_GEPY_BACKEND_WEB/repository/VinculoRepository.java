package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.CargoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.FuncionarioEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.VinculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VinculoRepository extends JpaRepository<VinculoEntity, Long> {

    @Query(value = "SELECT v.* FROM vinculo v ORDER BY v.id", nativeQuery = true)
    List<VinculoEntity> findAllOrderedById();

    @Query(value = "SELECT v.* FROM vinculo v JOIN funcionario f ON v.id_funcionario = f.id JOIN cargo c ON v.id_cargo = c.id WHERE c.id = ?", nativeQuery = true)
    List<VinculoEntity> findFuncionarioByCargo(Long idCargo);

    boolean existsByFuncionarioAndCargo(FuncionarioEntity funcionario, CargoEntity cargo);

}
