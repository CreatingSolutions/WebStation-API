package webstationapi.Repository;

import org.springframework.data.repository.CrudRepository;
import webstationapi.Entity.Account;

import java.util.UUID;

public interface AccountRepository extends CrudRepository<Account, Integer> {
}
