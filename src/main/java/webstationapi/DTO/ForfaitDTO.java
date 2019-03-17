package webstationapi.DTO;

public class ForfaitDTO {

    private Long id;

    private String label;

    private Double prices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrice(Double price) {
        this.prices = price;
    }
}
