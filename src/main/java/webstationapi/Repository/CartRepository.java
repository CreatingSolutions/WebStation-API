package webstationapi.Repository;

import org.springframework.data.repository.CrudRepository;

import webstationapi.Entity.Cart;
import webstationapi.Entity.User;

public interface CartRepository extends CrudRepository<Cart, Integer> {

    Cart findByUser(User user);

}
