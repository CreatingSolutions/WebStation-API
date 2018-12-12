package webstationapi.Repository;

import org.springframework.data.repository.CrudRepository;

import webstationapi.Entity.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {

}
