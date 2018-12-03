package webstationapi.Security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.ArrayList;

public class WebStationAuthenticationProvider implements AuthenticationProvider {

    // Repo Account
    // Account Manager


    public WebStationAuthenticationProvider() {
        // @NotNull manager
        // Repo Account

    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        // revoir pour justement recup un user From Db
        return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }

}
