package webstationapi.DTO;

import java.util.List;

public class LiftDTO {

    private String description;

    private List<ForfaitDTO> normal;

    private List<ForfaitDTO> diamant;

    private ForfaitDTO unitaire;

    private ForfaitDTO groupe;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ForfaitDTO> getNormal() {
        return normal;
    }

    public void setNormal(List<ForfaitDTO> normal) {
        this.normal = normal;
    }

    public List<ForfaitDTO> getDiamant() {
        return diamant;
    }

    public void setDiamant(List<ForfaitDTO> diamant) {
        this.diamant = diamant;
    }

    public ForfaitDTO getUnitaire() {
        return unitaire;
    }

    public void setUnitaire(ForfaitDTO unitaire) {
        this.unitaire = unitaire;
    }

    public ForfaitDTO getGroupe() {
        return groupe;
    }

    public void setGroupe(ForfaitDTO groupe) {
        this.groupe = groupe;
    }
}
