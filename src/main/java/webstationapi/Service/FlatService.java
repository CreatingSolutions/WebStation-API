package webstationapi.Service;


import org.springframework.stereotype.Service;
import webstationapi.Entity.FlatsBook;
import webstationapi.Repository.FlatsBookRepository;

import java.util.List;

@Service
public class FlatService {


    private FlatsBookRepository flatsBookRepository;

    public FlatService(FlatsBookRepository flatsBookRepository) {
        this.flatsBookRepository = flatsBookRepository;
    }

    public Long addcart(int userId, int flatId) {

        FlatsBook flatsBook = new FlatsBook();
        flatsBook.setIdflat(flatId);
        flatsBook.setUserid(userId);
        FlatsBook save = this.flatsBookRepository.save(flatsBook);

        return save.getId();
    }

    public List<FlatsBook> getcart(int userId) {

        return this.flatsBookRepository.findAllByUserid(userId);

    }
}
