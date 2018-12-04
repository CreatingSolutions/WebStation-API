package webstationapi.DTO;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class CredentialsDTO {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

}
