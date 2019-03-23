package webstationapi.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class StuffBook {

    private Long id;

    private int userId;

    private Long idStuff;

    private Double price;
}
