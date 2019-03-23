package webstationapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import webstationapi.DTO.CartFinalDTO;
import webstationapi.Entity.FlatsBook;
import webstationapi.Entity.LiftBooking;
import webstationapi.Entity.StuffBook;
import webstationapi.Service.CartService;
import webstationapi.Service.FlatService;
import webstationapi.Service.TokenService;
import webstationapi.Utils.Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

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

    @Autowired
    private FlatService flatService;

    @GetMapping("")
    public CartFinalDTO retriveCart(HttpServletRequest request) {
        String authorization = request.getHeader("authorization");
        if (authorization == null)
            return null;

        String token = Utils.getToken(authorization);
        int userId = this.tokenService.getUserId(token);

        //List<StuffBook> stuffCart = this.getStuffCart(userId);
       // List<LiftBooking> mecaCart = this.getMecaCart(userId);
        //List<FlatsBook> flatcart = this.flatService.getcart(userId);

       // double sumStuff = stuffCart.stream().mapToDouble(StuffBook::getPrice).sum();
       // double sumMeca = mecaCart.stream().mapToDouble(LiftBooking::getPrice).sum();


        CartFinalDTO cartFinalDTO = new CartFinalDTO();
        cartFinalDTO.setCartId(1L);
        //cartFinalDTO.setTotalStuffPrice(sumStuff);
        cartFinalDTO.setTotalLiftPrice(42.0);



        return cartFinalDTO;
    }

    private List<LiftBooking> getMecaCart(int userId) {
        UriComponentsBuilder builder = this.buildUrl(userId, baseurllift + "/liftbook");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<LiftBooking>> exchange = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<LiftBooking>>() {
                });
        return exchange.getBody();
    }

    private List<StuffBook> getStuffCart(int userId) {
        UriComponentsBuilder builder = this.buildUrl(userId, baseurlstuff + "/stuffs");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<StuffBook>> exchange = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<StuffBook>>() {
                });
        return exchange.getBody();
    }

    private UriComponentsBuilder buildUrl(int iduser, String url) {
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("iduser", iduser);
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
