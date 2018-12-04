package webstationapi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webstationapi.DTO.CredentialsDTO;
import webstationapi.Entity.Token;
import webstationapi.Entity.User;
import webstationapi.Service.AuthenticationService;
import webstationapi.Service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    private final UserService userService;

    @PostMapping(path = "/login")
    public Token login(@Valid @RequestBody final CredentialsDTO credentials) {
        return authenticationService.login(credentials.getEmail(), credentials.getPassword());
    }

    @GetMapping(path = "/logout")
    public ResponseEntity<Void> logout() {
        return null; // TODO : le finir voir un truc sur le token
    }

    @PostMapping(path = "/register")
    public User register(@Valid @RequestBody final CredentialsDTO credentials) {
        return userService.register(credentials.toUser());
    }


}
