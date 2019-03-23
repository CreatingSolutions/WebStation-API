package webstationapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import webstationapi.DTO.PackDTO;

@RestController
@RequestMapping(path = "/ecole")
public class SchoolController {

	@Value("${api.ecole.url}")
    private String baseUrl;

	@GetMapping(path = "/pack")
    public @ResponseBody
    List<PackDTO> getPacks() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<PackDTO>> response = restTemplate.exchange(
                baseUrl + "/pack/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PackDTO>>() {
                });
        List<PackDTO> packs = response.getBody();
        return packs;
    }

}
