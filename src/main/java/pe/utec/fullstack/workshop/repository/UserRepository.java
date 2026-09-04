package pe.utec.fullstack.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity> {

    //select * from users where enabled = true and username = '${userName}'
    Optional<UserEntity> findByEnabledTrueAndUserName(String userName);
}
