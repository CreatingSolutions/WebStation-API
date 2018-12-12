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

    /*
    @Column(name = "applicationToken")
    @JsonIgnore
    private String encodedApplicationToken;
*/
}