package webstationapi.Controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import webstationapi.DTO.CartDTO;
import webstationapi.Entity.Cart;
import webstationapi.Entity.Flat;
import webstationapi.Service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	@GetMapping(path = "/cart")
    public CartDTO retrieveCart(int userId) {
    	CartDTO result = new CartDTO();
    	
    	Collection<Flat> flats = new ArrayList<Flat>();
    	Cart cart = cartService.findByUserId(userId);
    	
    	for (int flatId : cart.getFlatIds()) {
    		RestTemplate restTemplate = new RestTemplate();
    		flats.add(restTemplate.getForObject("http://localhost:8083/flat/{flatID}", Flat.class, flatId));
    	}
    	
    	result.setFlats(flats);
    	
    	return result;
    }
	
}
