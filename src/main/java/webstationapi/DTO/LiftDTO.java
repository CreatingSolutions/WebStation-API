package webstationapi.DTO;

public class LiftDTO {

    private Long id;

    private boolean insurrance = false;

    private boolean isDiamond = false;

    private double nbFois = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isInsurrance() {
        return insurrance;
    }

    public void setInsurrance(boolean insurrance) {
        this.insurrance = insurrance;
    }

    public boolean isDiamond() {
        return isDiamond;
    }

    public void setDiamond(boolean diamond) {
        isDiamond = diamond;
    }

    public double getNbFois() {
        return nbFois;
    }

    public void setNbFois(double nbFois) {
        this.nbFois = nbFois;
    }
}
