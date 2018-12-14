package webstationapi.Controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import webstationapi.Entity.Flat;

@RestController
@RequestMapping(path = "/flat")
public class FlatController {

    private String baseUrl = "http://51.75.140.39:8083";

//    private String logementURL = "http://localhost:8083/flats";

    @GetMapping
    public @ResponseBody List<Flat> getFlats() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Flat>> response = restTemplate.exchange(
                baseUrl+"/flats",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Flat>>() {
                });
        List<Flat> flats = response.getBody();
        return flats;
    }
}
