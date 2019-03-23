package webstationapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webstationapi.Entity.FlatsBook;

public interface FlatsBookRepository extends JpaRepository<FlatsBook, Long> {
}
