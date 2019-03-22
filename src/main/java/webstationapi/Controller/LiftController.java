package webstationapi.Controller;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import webstationapi.DTO.ForfaitCartDTO;
import webstationapi.DTO.ForfaitDTO;
import webstationapi.DTO.LiftDTO;
import webstationapi.DTO.TokenDTO;
import webstationapi.Entity.Lift;
import webstationapi.Entity.LiftBooking;
import webstationapi.Entity.Token;
import webstationapi.Enum.AgeEnum;
import webstationapi.Enum.TypeEnum;
import webstationapi.Utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping(path = "/lifts")
public class LiftController {

    @Value("${api.lift.url}")
    private String baseUrl;


    private TypeEnum getType(String type) {
        if ("skialpin".equals(type))
            return TypeEnum.ALPIN;
        else if ("skinordique".equals(type))
            return TypeEnum.NORDIQUE;
        else
            return TypeEnum.TELESIEGE;
    }

    private AgeEnum getAge(String age) {
        if ("jeunes".equals(age))
            return AgeEnum.JEUNE;
        else if ("adultes".equals(age))
            return AgeEnum.ADULTE;
        else if ("senior".equals(age))
            return AgeEnum.SENIOR;
        else
            return AgeEnum.AGE_OR;
    }

    private UriComponentsBuilder buildUrl(TypeEnum typeEnum, AgeEnum ageEnum) {
        return UriComponentsBuilder.fromHttpUrl(baseUrl + "/lift")
                .queryParam("type", typeEnum)
                .queryParam("age", ageEnum);
    }

    private LiftDTO makeLiftRequest(UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<LiftDTO> exchange = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<LiftDTO>() {
                });
        return exchange.getBody();
    }

    @GetMapping("/{type}/{age}")
    public LiftDTO getAllForfait(@PathVariable("type") String type, @PathVariable("age") String age) {

        TypeEnum typeEnum = this.getType(type);
        AgeEnum ageEnum = this.getAge(age);

        UriComponentsBuilder builder = this.buildUrl(typeEnum, ageEnum);
        return this.makeLiftRequest(builder);
    }

    @GetMapping("/telesiege")
    public LiftDTO getTelesiege() {

        UriComponentsBuilder builder = this.buildUrl(TypeEnum.TELESIEGE, AgeEnum.JEUNE);
        return this.makeLiftRequest(builder);
    }


    @GetMapping("{id}")
    public Lift getLift(@PathVariable Long id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Lift> exchange = restTemplate.exchange(baseUrl + "/lift/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Lift>() {
                });
        return exchange.getBody();
    }

    @PostMapping("price")
    public Double getCalculePrice(@RequestBody List<LiftDTO> liftDTOS) {
        RestTemplate template = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<List<LiftDTO>> requestEntity = new HttpEntity<>(liftDTOS, headers);
        ResponseEntity<Double> response = template.exchange(baseUrl + "/lift/price", HttpMethod.POST, requestEntity, Double.class);
        return response.getBody();
    }

    // Booking

    @PostMapping("/")
    public void addForfaitToCart(ForfaitCartDTO forfaitCartDTO, HttpServletRequest request){

        String token = Utils.getToken(request.getHeader("authorization"));


       



    }



    @GetMapping("/liftbooking/{id}")
    public List<LiftBooking> getActiveBookByUser(@PathVariable Long id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<LiftBooking>> exchange = restTemplate.exchange(baseUrl + "/liftbooking/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<LiftBooking>>() {
                });
        return exchange.getBody();
    }

    @PostMapping("/liftbooking/{idUser}")
    public void makeBook(@RequestBody List<LiftDTO> liftDTOS, @PathVariable Long idUser) {
        RestTemplate template = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<List<LiftDTO>> requestEntity = new HttpEntity<>(liftDTOS, headers);

        template.exchange(baseUrl + "/liftbooking/" + idUser, HttpMethod.POST, requestEntity, Object.class);
    }

    @GetMapping("/liftbooking/pdf/{iduser}")
    public void generatePdf(@PathVariable Long iduser) throws FileNotFoundException, DocumentException {
        // also validate book
        // Need TO Generate IN API
        //this.liftBookingService.makePdf(iduser);
    }

}
