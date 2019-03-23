package webstationapi.DTO;

import lombok.Data;

import java.util.List;

@Data
public class StuffDTO {

    private Long stuffId;

    private String title;

    private String store;

    private String img;

    private Double price;

    private List<QualityDTO> qualities;

}
