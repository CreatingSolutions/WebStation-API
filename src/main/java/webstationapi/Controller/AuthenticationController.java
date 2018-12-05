package webstationapi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webstationapi.DTO.ApiErrorDTO;
import webstationapi.DTO.CredentialsDTO;
import webstationapi.DTO.TokenDTO;
import webstationapi.Entity.Token;
import webstationapi.Entity.User;
import webstationapi.Exception.WebStationException;
import webstationapi.Service.AuthenticationService;
import webstationapi.Service.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.ZoneId;

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
    public ResponseEntity<Void> logout(TokenDTO token) {
        authenticationService.logout(token);
        return null;
    }

    @PostMapping(path = "/register")
    public User register(@Valid @RequestBody final CredentialsDTO credentials) {
        return userService.register(credentials.toUser());
    }

    @ExceptionHandler(WebStationException.class)
    public ResponseEntity<ApiErrorDTO> handleException(WebStationException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ApiErrorDTO.builder()
                        .details(ex.getMessage())
                        .msg("non autorisé")
                        .status(HttpStatus.UNAUTHORIZED)
                        .timestamp(LocalDateTime.now(ZoneId.of("UTC")))
                        .build());
    }

}
