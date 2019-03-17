package webstationapi.DTO;

import java.util.List;

public class StuffDTO {

    private Long stuffId;

    private String title;

    private String store;

    private String img;

    private List<QualityDTO> qualityDTOS;

    public Long getStuffId() {
        return stuffId;
    }

    public void setStuffId(Long stuffId) {
        this.stuffId = stuffId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<QualityDTO> getQualityDTOS() {
        return qualityDTOS;
    }

    public void setQualityDTOS(List<QualityDTO> qualityDTOS) {
        this.qualityDTOS = qualityDTOS;
    }
}
