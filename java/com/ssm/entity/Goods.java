package com.ssm.entity;

import java.util.Date;

public class Goods {
    private String id;//商品编号
    private int goods_type_id;//商品类别编号
    private  int user_id;
    private User user;//用户编号，谁发布的
    private String name;//商品名称
    private float price;//商品出售价格
    private float real_price;//商品原价
    private String release_date;//发布时间
    private Goodstate goodstate;//商品状态
    private int status;//状态：上架 下架
    private int repertory;//商品库存
    private String remove_date;//下架时间
    private String describle;//商品描述
    private String img;//商品图片

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getGoods_type_id() {
        return goods_type_id;
    }

    public void setGoods_type_id(int goods_type_id) {
        this.goods_type_id = goods_type_id;
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

    public float getReal_price() {
        return real_price;
    }

    public void setReal_price(float real_price) {
        this.real_price = real_price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRepertory() {
        return repertory;
    }

    public void setRepertory(int repertory) {
        this.repertory = repertory;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getRemove_date() {
        return remove_date;
    }

    public void setRemove_date(String remove_date) {
        this.remove_date = remove_date;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle;
    }

    public Goodstate getGoodstate() {
        return goodstate;
    }

    public void setGoodstate(Goodstate goodstate) {
        this.goodstate = goodstate;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id='" + id + '\'' +
                ", goods_type_id=" + goods_type_id +
                ", user_id=" + user_id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", real_price=" + real_price +
                ", release_date='" + release_date + '\'' +
                ", goodstate=" + goodstate +
                ", status=" + status +
                ", repertory=" + repertory +
                ", remove_date='" + remove_date + '\'' +
                ", describle='" + describle + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
