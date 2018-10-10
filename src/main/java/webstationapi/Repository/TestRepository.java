package webstationapi.Repository;

import org.springframework.data.repository.CrudRepository;
import webstationapi.Entity.Test;

public interface TestRepository extends CrudRepository<Test, Integer> {
}
