package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.CargoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CargoRepository extends JpaRepository<CargoEntity, Long> {

    @Query(value = "SELECT c.* FROM cargo c ORDER BY c.id", nativeQuery = true)
    List<CargoEntity> findAllOrderedById();

}
