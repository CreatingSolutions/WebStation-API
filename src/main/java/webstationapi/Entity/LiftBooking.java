package webstationapi.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class LiftBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int idUser;

    private Long idLift;

    private boolean insurrance = false;

    private int taked = 0;

    private Double price;

    boolean valid = false;
}
