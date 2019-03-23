package webstationapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import webstationapi.DTO.StuffBookDTO;
import webstationapi.DTO.StuffDTO;
import webstationapi.DTO.StuffSendDTO;
import webstationapi.Service.TokenService;
import webstationapi.Utils.Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/stuffs")
public class StuffController {

    @Value("${api.stuff.url}")
    private String baseUrl;

    @Autowired
    private TokenService tokenService;

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

    @PostMapping("")
    public void addForfaitToCart(@RequestBody StuffBookDTO stuffBookDTO, HttpServletRequest request) {

        String authorization = request.getHeader("authorization");
        if (authorization == null)
            return;

        String token = Utils.getToken(authorization);
        int userId = this.tokenService.getUserId(token);

        StuffSendDTO stuffSendDTO = new StuffSendDTO();
        stuffSendDTO.setUserId(userId);
        stuffSendDTO.setTaked(stuffBookDTO.getTaked());
        stuffSendDTO.setStuffId(stuffBookDTO.getStuffId());


        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<StuffSendDTO> requestEntity = new HttpEntity<>(stuffSendDTO, headers);
        ResponseEntity<Long> response = template.exchange(baseUrl + "/stuffs/add", HttpMethod.POST, requestEntity, Long.class);

    }
}
