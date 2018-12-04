package webstationapi.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webstationapi.DTO.CredentialsDTO;
import webstationapi.Entity.Token;
import webstationapi.Entity.User;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/")
public class AuthenticationController {

    //private final AuthenticationService authenticationService;

    //private final UserService userService;

    @PostMapping(path = "/login")
    public Token login(@Valid @RequestBody final CredentialsDTO credentials) {

        return null;
    }

    @GetMapping(path = "/logout")
    public ResponseEntity<Void> logout() {
        return null;
    }

    @PostMapping(path = "/register")
    public User register() {
        return null;
    }


}
