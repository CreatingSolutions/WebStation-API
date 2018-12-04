package webstationapi.Repository;

import org.springframework.data.repository.CrudRepository;
import webstationapi.Entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
