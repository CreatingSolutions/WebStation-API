package webstationapi.Security;

import java.util.Collection;
import java.util.stream.Collectors;

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

@Component
public class ApplicationUserDetailsService implements UserDetailsService {

	@Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final User user = userService.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        final Collection<? extends GrantedAuthority> userRoles = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
        return new UserDetails() {
			private static final long serialVersionUID = -3362032501326711265L;

			@Override
            public Collection<? extends GrantedAuthority> getAuthorities() { return userRoles; }

            @Override
            public String getPassword() { return user.getToken() == null ? null : user.getToken().getApplicationToken(); }

            @Override
            public String getUsername() { return String.valueOf(user.getId()); }

            @Override
            public boolean isAccountNonExpired() { return false; }

            @Override
            public boolean isAccountNonLocked() { return false; }

            @Override
            public boolean isCredentialsNonExpired() { return false; }

            @Override
            public boolean isEnabled() { return false; }
        };
    }

}