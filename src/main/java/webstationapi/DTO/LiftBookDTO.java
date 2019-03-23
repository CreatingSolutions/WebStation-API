package webstationapi.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LiftBookDTO {

    private Long liftId;

    private int userId;

    private boolean insurance;

    private int taked;
}
