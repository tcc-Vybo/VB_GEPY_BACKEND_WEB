package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.PerfilVinculoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.TurmaDisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PerfilVinculoRepository extends JpaRepository<PerfilVinculoEntity, Long> {

    @Query(value = "SELECT pv.* FROM perfil_vinculo pv ORDER BY pv.id", nativeQuery = true)
    List<PerfilVinculoEntity> findAllOrderedById();
}
