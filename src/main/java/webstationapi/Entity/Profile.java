package webstationapi.Entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uuid;

    /* OneToOne */
    // private User account;

    private String firstName;
    private String lastName;
    private Date birthDate;

	public int getUuid() { return uuid; }
	public void setUuid(int uuid) { this.uuid = uuid; }
	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public Date getBirthDate() { return birthDate; }
	public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
}
