package webstationapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webstationapi.Entity.FlatsBook;

import java.util.List;

public interface FlatsBookRepository extends JpaRepository<FlatsBook, Long> {

    public List<FlatsBook> findAllByUserid(int userid);
}
