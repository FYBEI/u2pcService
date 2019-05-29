package com.uestc2h.u2pc.controller.DTO;

import java.io.File;

public class PictureDTO {
    /**
     * imgId
     */
    private Long imgId;

    /**
     * name
     */
    private String name;

    /**
     * size
     */
    private Long size;

    /**
     *userId or commodityId
     */
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getImgId() {
        return imgId;
    }

    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
