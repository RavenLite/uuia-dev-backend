package uuia.info.devbackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uuia.info.devbackend.entity.App;

import java.util.List;

@Repository
public interface AppRepository extends JpaRepository<App,Integer> {

    List<App> findAllByOwnerId(int ownerId);

    App findByUuiaAppId(String uuiaAppId);

    App findByWechatAppId(String wechatAppId);

    App findByQqAppId(String qqAppId);

    App findById(int id);
}
