package webstationapi.DTO;

import lombok.Data;

import java.util.List;

@Data
public class LiftDTO {

    private String description;

    private List<ForfaitDTO> normal;

    private List<ForfaitDTO> diamant;

    private ForfaitDTO unitaire;

    private ForfaitDTO groupe;

}
