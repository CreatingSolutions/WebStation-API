package webstationapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import webstationapi.DTO.CartDTO;
import webstationapi.Entity.Cart;
import webstationapi.Entity.Flat;
import webstationapi.Service.CartService;
import webstationapi.Service.TokenService;
import webstationapi.Utils.Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(path = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Value("${api.flat.url}")
    private String baseurlflat;

    @Value("${api.stuff.url}")
    private String baseurlstuff;

    @Value("${api.lift.url}")
    private String baseurllift;

    @Value("${api.ecole.url}")
    private String baseurlecole;

    @Autowired
    private TokenService tokenService;

    @GetMapping("")
    public void retriveCart(HttpServletRequest request){
        String authorization = request.getHeader("authorization");
        if (authorization == null)
            return;

        String token = Utils.getToken(authorization);
        int userId = this.tokenService.getUserId(token);

        System.out.println(userId);
    }

    /*
    @GetMapping
    public CartDTO retrieveCart(int userId) {
        CartDTO result = new CartDTO();

        Collection<Flat> flats = new ArrayList<Flat>();
        Cart cart = cartService.findByUserId(userId);

        if (cart == null)
            return new CartDTO();

        for (int flatId : cart.getFlatIds()) {
            if (flatId != 0) {
                RestTemplate restTemplate = new RestTemplate();
                Flat flt = restTemplate.getForObject("http://51.75.140.39:8083/flat/{id}", Flat.class, flatId);
                flats.add(flt);
            }
        }

        result.setUserid(cart.getUser().getId());
        result.setFlats(flats);
        return result;
    }*/

    @PostMapping(path = "/addOne")
    public void addCart(@RequestParam int userId, @RequestParam int flatId) {
        cartService.addCartOneElement(userId, flatId);
    }

    @PostMapping(path = "/removeElements")
    public void removeElement(@RequestParam int userId, @RequestParam Collection<Integer> flatIds) {
        cartService.removeElements(userId, flatIds);
    }

    @PostMapping(path = "/addElements")
    public void addCartM(@RequestParam int userId, @RequestParam Collection<Integer> flatId) {
        cartService.addCartElements(userId, flatId);
    }

    @PostMapping(path = "/valider")
    public void validatePanier() {
        /* Ici, il faut :
         * - Valider le paiement,
         * - Enregistrer les réservations en base,
         * - Supprimer le panier pour actualiser le front si et seulement si tout s'est bien passé. */
        //cartService.delete(userId);
//        return true;
    }

    @PostMapping(path = "/delete")
    public void deletePanier(@RequestParam int userId) {
        cartService.delete(userId);
    }


}
