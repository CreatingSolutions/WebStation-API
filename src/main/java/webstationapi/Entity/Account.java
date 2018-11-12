package webstationapi.Entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "guid"
    )
    @Column(name = "uuid", updatable = false, nullable = false, columnDefinition = "VARCHAR(255)")
    private UUID uuid;

    private String emailAddress;

    private String encodedPassword;

    private String salt;

    //private Profile profile;
}
