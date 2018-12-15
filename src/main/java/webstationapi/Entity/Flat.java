package webstationapi.Entity;

public class Flat {

    long idFlat;
    String description;
    String nbPersonnes;
    boolean sdbwc;
    boolean pets;
    boolean wifi;
    String orientation;
    String title;

    public long getIdFlat() {
        return idFlat;
    }

    public void setId_flat(long id_flat) {
        this.idFlat = id_flat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdFlat(long idFlat) {
        this.idFlat = idFlat;
    }

    public String getNbPersonnes() {
        return nbPersonnes;
    }

    public void setNbPersonnes(String nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }

    public boolean isSdbwc() {
        return sdbwc;
    }

    public void setSdbwc(boolean sdbwc) {
        this.sdbwc = sdbwc;
    }

    public boolean isPets() {
        return pets;
    }

    public void setPets(boolean pets) {
        this.pets = pets;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
