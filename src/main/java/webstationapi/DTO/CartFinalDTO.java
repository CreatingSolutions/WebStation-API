package webstationapi.DTO;

import lombok.Data;

import java.util.List;

@Data
public class CartFinalDTO {

    private Long cartId;

    private int userId;

    private List<FlatGetDTO> flats;

    private Double totalFlatPrice;

    private List<LiftGetDTO> lifts;

    private Double totalLiftPrice;

    private List<StuffGetDTO> stuffs;

    private Double totalStuffPrice;

    private Double totalPrice;

    private Boolean validate;

    private Boolean paid;

}
