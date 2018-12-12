package webstationapi.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webstationapi.DTO.TokenDTO;
import webstationapi.Entity.Token;
import webstationapi.Entity.User;
import webstationapi.Exception.WebStationException;
import webstationapi.Security.ApplicationPasswordEncoder;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationService {


    private final UserService userService;

    private final TokenService tokenService;

    private final ApplicationPasswordEncoder passwordEncoder;

    @Transactional
    public Token login(final String email, final String password) {
        return createNewToken(getUserfromCredentials(email, password));
    }

    private User getUserfromCredentials(final String email, final String password) {
        final User user = userService.findByEmail(email);
        if (user == null) {
            throw new WebStationException("user not exist");
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new WebStationException("Password not Match");
        }
        return user;
    }

    private Token createNewToken(final User user) {

        if (user.getToken() != null) {
            tokenService.delete(user.getToken());
        }

        final Token token = new Token();
        final String applicationToken = passwordEncoder.newRawApplicationToken();
        token.setApplicationToken(applicationToken);
        //token.setEncodedApplicationToken(passwordEncoder.encode(applicationToken));
        token.setUser(user);
        tokenService.save(token);

        // Affect this new token to user
        user.setToken(token);
        userService.update(user);
        return token;
    }

    public void logout(@NonNull final TokenDTO user) {
        tokenService.deleteFrom(user);
    }

}
