package webstationapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Setter
@Getter
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    @Column(name = "applicationToken")
    private String applicationToken;

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public User getUser() { return user; }
	public void setUser(User user) { this.user = user; }
	public String getApplicationToken() { return applicationToken; }
	public void setApplicationToken(String applicationToken) { this.applicationToken = applicationToken; }

    /*
    @Column(name = "applicationToken")
    @JsonIgnore
    private String encodedApplicationToken;
*/
}