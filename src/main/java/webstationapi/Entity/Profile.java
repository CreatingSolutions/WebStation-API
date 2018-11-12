package webstationapi.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Profile")
public class Profile {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "guid"
    )
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID uuid;

    /* OneToOne */
   // private Account account;

    private String firstName;

    private String lastName;

    private Date birthDate;
}
