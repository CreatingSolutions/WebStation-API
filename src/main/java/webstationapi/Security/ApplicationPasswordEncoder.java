package webstationapi.Security;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApplicationPasswordEncoder implements PasswordEncoder {

    private static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Override
    public String encode(final CharSequence charSequence) {
        return PASSWORD_ENCODER.encode(charSequence);
    }

    @Override
    public boolean matches(final CharSequence charSequence, final String s) {
        return PASSWORD_ENCODER.matches(charSequence, s);
    }

    public String newRawApplicationToken() {
        return DigestUtils.sha256Hex(UUID.randomUUID().toString());
    }

}