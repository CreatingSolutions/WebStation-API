package webstationapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import webstationapi.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmailAddress(String emailAddress);

}
