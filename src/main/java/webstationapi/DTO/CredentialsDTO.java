package webstationapi.DTO;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import webstationapi.Entity.User;

@Getter
@Setter
public class CredentialsDTO {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    public User toUser() {
        User user = new User();
        user.setEmailAddress(getEmail());
        user.setPassword(getPassword());
        return user;
    }
}
