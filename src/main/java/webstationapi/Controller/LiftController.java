package webstationapi.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import webstationapi.Entity.Lift;
import webstationapi.Enum.AgeEnum;
import webstationapi.Enum.TypeEnum;

import java.util.List;

@RestController
@RequestMapping(path = "/lift")
public class LiftController {

    @Value("${api.lift.url}")
    private String baseUrl;

    @GetMapping
    public List<Lift> getLiftByTypeAndAge(@RequestParam(value = "type") TypeEnum type, @RequestParam(value = "age") AgeEnum age) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Lift>> exchange = restTemplate.exchange(baseUrl + "/lift",
                HttpMethod.GET,
                null,
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

}
