package uuia.info.devbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uuia.info.devbackend.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findById(int id);

    User findByMail(String mail);

    User findByUsername(String username);

    User findByPhone(String phone);

    User findByCode(String code);
}
