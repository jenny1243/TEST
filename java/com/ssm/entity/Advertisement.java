package com.ssm.entity;

public class Advertisement {
    private int id;
    private String img;
    private int userid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", userid=" + userid +
                '}';
    }
}
