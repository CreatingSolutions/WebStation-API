package webstationapi.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "Account")
public class Account {

    private UUID uuid;

    private String emailAddress;

    private String encodedPassword;

    private String salt;

    private Profile profile;
}
