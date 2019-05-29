package com.uestc2h.u2pc.controller.DTO;

public class UserDTO {
    /**
     * userId
     */
    private Long userId;

    /**
     * userName
     */
    private String userName;

    /**
     * password
     */
    private String password;

    /**
     * sign
     */
    private String sign;

    /**
     * phone
     */
    private String phone;

    /**
     * email同时也是登录账号
     */
    private String email;

    /**
     * headImg
     */
    private PictureDTO img;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PictureDTO getImg() {
        return img;
    }

    public void setImg(PictureDTO img) {
        this.img = img;
    }
}
