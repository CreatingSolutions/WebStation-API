package webstationapi.Repository;

import org.springframework.data.repository.CrudRepository;
import webstationapi.Entity.Token;
import webstationapi.Entity.User;

public interface TokenRepository extends CrudRepository<Token, Integer> {

    Token findByUser(User user);

    Token findByApplicationToken(String applicationToken);
}