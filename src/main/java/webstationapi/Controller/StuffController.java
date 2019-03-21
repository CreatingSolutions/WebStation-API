package webstationapi.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import webstationapi.DTO.StuffDTO;

import java.util.List;

@RestController
@RequestMapping(path = "/stuffs")
public class StuffController {

    @Value("${api.stuff.url}")
    private String baseUrl;

    private UriComponentsBuilder buildUrl() {
        return UriComponentsBuilder.fromHttpUrl(baseUrl + "/stuffs");
    }

    private List<StuffDTO> makeStuffRequest(UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<StuffDTO>> exchange = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<StuffDTO>>() {
                });
        return exchange.getBody();
    }

    @GetMapping
    public List<StuffDTO> getAllStuffs() {
        return this.makeStuffRequest(this.buildUrl());
    }


}
