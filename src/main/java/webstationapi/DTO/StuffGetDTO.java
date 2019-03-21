package webstationapi.DTO;


import lombok.Data;

@Data
public class StuffGetDTO {
    private Long stuffId;
    private String title;
    private String description;
    private int taked;
    private Double price;
}
