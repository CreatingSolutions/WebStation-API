package webstationapi.Controller;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webstationapi.DTO.APIErrorDTO;
import webstationapi.DTO.CredentialsDTO;
import webstationapi.DTO.TokenDTO;
import webstationapi.Entity.Token;
import webstationapi.Entity.User;
import webstationapi.Exception.WebStationException;
import webstationapi.Service.AuthenticationService;
import webstationapi.Service.UserService;

@RestController
@RequestMapping(path = "/")
public class AuthenticationController {

	@Autowired
    private AuthenticationService authenticationService;

	@Autowired
    private UserService userService;

    @PostMapping(path = "/login")
    public Token login(@Valid @RequestBody final CredentialsDTO credentials) {
        return authenticationService.login(credentials.getEmail(), credentials.getPassword());
    }

    @GetMapping(path = "/logout")
    public ResponseEntity<Void> logout(TokenDTO token) {
        authenticationService.logout(token);
        return null;
    }

    @PostMapping(path = "/register")
    public User register(@Valid @RequestBody final CredentialsDTO credentials) {
        return userService.register(credentials.toUser());
    }

    @ExceptionHandler(WebStationException.class)
    public ResponseEntity<APIErrorDTO> handleException(WebStationException ex) {
    	APIErrorDTO error = new APIErrorDTO();
    	error.setDetails(ex.getMessage());
    	error.setMsg("Non autorisé");
    	error.setStatus(HttpStatus.UNAUTHORIZED);
    	error.setTimestamp(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

}
