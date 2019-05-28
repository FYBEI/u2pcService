package com.uestc2h.u2pc.mapper.DTO;

import java.util.List;

public class CommodityDTO {
    /**
     * Id
     */
    Long id;

    /**
     * value
     */
    String name;

    /**
     * price
     */
    float price;

    /**
     * intro
     */
    String intro;

    /**
     * userId,物主的Id
     */
    Long userId;

    /**
     * kind
     */
    enum Kind{
        SHbook("二手书", 1), Live("生活用品", 2), Coat("服饰", 3), Digital("数码", 4), Learn("学习", 5), Sports("运动", 6);

        private String value;
        private int key;

        Kind(String value, int key) {
            this.value = value;
            this.key = key;
        }

        public static String getValue(int key){
            for (Kind k : Kind.values()) {
                if (k.getKey() == key) {
                    return k.value;
                }
            }
            return null;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }
    }

    /**
     * Pictures
     */
    List<PictureDTO> pictures;

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

    public List<PictureDTO> getPictures() {
        return pictures;
    }

    public void setPictures(List<PictureDTO> pictures) {
        this.pictures = pictures;
    }
}
