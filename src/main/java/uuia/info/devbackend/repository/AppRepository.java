package uuia.info.devbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uuia.info.devbackend.entity.App;

import java.util.List;

public interface AppRepository extends JpaRepository<App,Integer> {

    List<App> findAllByOwnerId(int ownerId);

    App findByUuiaAppId(String uuiaAppId);

    App findByWechatAppid(String wechatAppId);

    App findByQqAppid(String qqAppId);

    App findById(int id);
}
