package com.uestc2h.u2pc.entity;

import java.util.ArrayList;
import java.util.List;

public class Commodity {
    /**
     * Id
     */
    private Long id;

    /**
     * value
     */
    private String name;

    /**
     * price
     */
    private float price;

    /**
     * intro
     */
    private String intro;

    /**
     * userId,物主的Id
     */
    private Long userId;

    /**
     * sell
     */
    private boolean sell;

    /**
     * kind
     */
    String kind;

    /**
     * Pictures
     */
    private List<Picture> pictures;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public boolean isSell() {
        return sell;
    }

    public void setSell(boolean sell) {
        this.sell = sell;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
