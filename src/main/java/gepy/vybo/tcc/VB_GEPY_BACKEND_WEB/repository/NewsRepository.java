package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.NewsEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.TurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsRepository extends JpaRepository<NewsEntity, Long> {

    @Query(value = "SELECT n.* FROM news n ORDER BY n.id", nativeQuery = true)
    List<NewsEntity> findAllOrderedById();
}
