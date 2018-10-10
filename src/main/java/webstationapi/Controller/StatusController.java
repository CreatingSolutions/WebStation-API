package webstationapi.Controller;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class StatusController {

    @GetMapping("/status")
    @ResponseBody
    public ResponseEntity<String> sendViaResponseEntity() {
        return new ResponseEntity<>("ok", HttpStatus.CREATED);
    }

}
