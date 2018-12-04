package webstationapi.Security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import webstationapi.Entity.User;
import webstationapi.Service.UserService;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        Long userId;
        try {
            userId = Long.parseLong(username);
        } catch (NumberFormatException e) {
            throw new UsernameNotFoundException(username);
        }

        final User user = userService.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        final Collection<? extends GrantedAuthority> userRoles = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return userRoles;
            }

            @Override
            public String getPassword() {
                return user.getToken() == null ? null : user.getToken().getApplicationToken();
            }

            @Override
            public String getUsername() {
                return String.valueOf(user.getId());
            }

            @Override
            public boolean isAccountNonExpired() {
                return false;
            }

            @Override
            public boolean isAccountNonLocked() {
                return false;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return false;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }

        };
    }

}