package webstationapi.Entity;


public class LiftBooking {

    private Long id;

    private Long idUser;

    private Long idLift;

    private boolean insurrance = false;

    private boolean isDiamond = false;

    private double nbFois = 0;

    private Double price;

    boolean valid = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdLift() {
        return idLift;
    }

    public void setIdLift(Long idLift) {
        this.idLift = idLift;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
