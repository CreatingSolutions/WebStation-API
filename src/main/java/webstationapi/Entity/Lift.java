package webstationapi.Entity;

import webstationapi.Enum.AgeEnum;
import webstationapi.Enum.LabelEnum;
import webstationapi.Enum.TypeEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Lift {
    private Long id;

    @Enumerated(EnumType.STRING)
    private LabelEnum labeltype;

    private String label;

    @Enumerated(EnumType.STRING)
    private AgeEnum age;

    private Double price;

    private Double price_diamond;

    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    private Double insurrance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LabelEnum getLabeltype() {
        return labeltype;
    }

    public void setLabeltype(LabelEnum labeltype) {
        this.labeltype = labeltype;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public AgeEnum getAge() {
        return age;
    }

    public void setAge(AgeEnum age) {
        this.age = age;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice_diamond() {
        return price_diamond;
    }

    public void setPrice_diamond(Double price_diamond) {
        this.price_diamond = price_diamond;
    }


    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public Double getInsurrance() {
        return insurrance;
    }

    public void setInsurrance(Double insurrance) {
        this.insurrance = insurrance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;
}
