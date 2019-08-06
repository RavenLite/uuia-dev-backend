package uuia.info.devbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uuia.info.devbackend.entity.RelationUserApp;

import java.util.List;

public interface RelationUserAppRepository extends JpaRepository<RelationUserApp,Integer>{

    List<RelationUserApp> findAllByUserId(int userId);

    List<RelationUserApp> findAllByAppId(int appId);

    RelationUserApp findByUserIdAndAppId(int userId, int appId);
}
