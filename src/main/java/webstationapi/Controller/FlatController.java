package webstationapi.Controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import webstationapi.Entity.Flat;

import java.util.List;

@RestController
@RequestMapping(path = "/flat")
public class FlatController {

    private String logementURL = "127.0.0.1:8083";

    @GetMapping(path = "/")
    public @ResponseBody
    List<Flat> getFlats() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Flat>> response = restTemplate.exchange(
                "http://localhost:8083/flats",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Flat>>() {
                });
        List<Flat> flats = response.getBody();
        return flats;
    }
}
