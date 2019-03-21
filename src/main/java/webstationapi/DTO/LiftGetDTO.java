package webstationapi.DTO;

import lombok.Data;

@Data
public class LiftGetDTO {

    private Long liftId;

    private String title;

    private String description;

    private int taked;

    private boolean insurrance;

    private Double price;
}
