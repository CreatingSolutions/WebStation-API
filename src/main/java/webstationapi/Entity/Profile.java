package webstationapi.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uuid;

    /* OneToOne */
    // private Account account;

    private String firstName;

    private String lastName;

    private Date birthDate;
}
