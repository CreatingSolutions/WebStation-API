package webstationapi.Controller;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import webstationapi.DTO.LiftDTO;
import webstationapi.Entity.Lift;
import webstationapi.Entity.LiftBooking;
import webstationapi.Enum.AgeEnum;
import webstationapi.Enum.TypeEnum;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/lift")
public class LiftController {

    @Value("${api.lift.url}")
    private String baseUrl;

    // Lift

    @GetMapping
    public List<Lift> getLiftByTypeAndAge(@RequestParam(value = "type") TypeEnum type, @RequestParam(value = "age") AgeEnum age) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl + "/lift")
                .queryParam("type", type)
                .queryParam("age", age);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Lift>> exchange = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Lift>>() {
                });
        return exchange.getBody();
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
