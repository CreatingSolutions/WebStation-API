package webstationapi.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import webstationapi.Entity.Flat;
import webstationapi.Service.FlatService;
import webstationapi.Service.TokenService;
import webstationapi.Utils.Utils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/flats")
public class FlatController {

    @Value("${api.flat.url}")
    private String baseUrl;

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private TokenService tokenService;

    @Autowired
    private FlatService flatService;

    @GetMapping
    public @ResponseBody
    List<Flat> getFlats() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Flat>> response = restTemplate.exchange(
                baseUrl + "/flats",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Flat>>() {
                });
        List<Flat> flats = response.getBody();
        return flats;
    }


    @PostMapping
    public void addtoCart(@RequestBody String body, HttpServletRequest request) throws IOException {

        String authorization = request.getHeader("authorization");
        if (authorization == null)
            return;

        String token = Utils.getToken(authorization);
        int userId = this.tokenService.getUserId(token);

        final JsonNode jsonNode = mapper.readTree(body);
        int flatId = jsonNode.findValue("flatId").asInt(1);
        this.flatService.addcart(userId, flatId);

    }


}
