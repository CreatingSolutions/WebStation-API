package webstationapi.DTO;

import lombok.Data;

@Data
public class FlatGetDTO {

    private Long flatId;

    private String title;

    private String description;

    private Double price;

}
