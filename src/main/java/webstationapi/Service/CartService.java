package webstationapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webstationapi.Entity.Cart;
import webstationapi.Exception.WebStationException;
import webstationapi.Repository.CartRepository;

@Service
public class CartService {
	
    @Autowired
    private CartRepository cartRepository;

	public Cart findByUserId(int userId) {
		return cartRepository.findById(userId).orElseThrow(() -> new WebStationException("No cart found with this UserID"));
	}
	
}
