package webstationapi.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Profile")
public class Profile {

    private UUID uuid;

    /* OneToOne */
    private Account account;

    private String firstName;

    private String lastName;

    private Date birthDate;
}
