package webstationapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webstationapi.Entity.Cart;
import webstationapi.Entity.User;
import webstationapi.Exception.WebStationException;
import webstationapi.Repository.CartRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserService userService;


    @Transactional
    public Cart findByUserId(int userId) {
        User user = this.userService.findById(userId);
        if (user == null)
            return null;
        return cartRepository.findByUser(user);
    }

    @Transactional
    public void addCartOneElement(int userid, int idflat) {
        User user = this.userService.findById(userid);
        if (user == null)
            return;
        Cart cart = this.findByUserId(userid);

        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cart.addFlatId(idflat);
        }else{
            cart.addFlatId(idflat);
        }
        this.cartRepository.save(cart);
    }

    @Transactional
    public void addCartElements(int userid, Collection<Integer> elements) {
        User user = this.userService.findById(userid);
        if (user == null)
            return;
        Cart cart = this.findByUserId(userid);

        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cart.setFlatIds(elements);
        }else{
            cart.setFlatIds(elements);
        }
        this.cartRepository.save(cart);
    }
}
