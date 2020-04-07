package com.ssm.entity;

public class Order {
    private int id;//订单表编号
    private int user_id;//买家编号
    private User user;//买家
    private Orderstate orderstate;//订单状态（待收货 待发货 已完成）
    private int order_num;//订单编号
    private float order_price;//订单总价
    private int order_state;//订单状态码
    private String order_date;//订单创建时间
    private String order_message;//订单备注

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Orderstate getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Orderstate orderstate) {
        this.orderstate = orderstate;
    }

    public int getOrder_num() {
        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public float getOrder_price() {
        return order_price;
    }

    public void setOrder_price(float order_price) {
        this.order_price = order_price;
    }

    public int getOrder_state() {
        return order_state;
    }

    public void setOrder_state(int order_state) {
        this.order_state = order_state;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_message() {
        return order_message;
    }

    public void setOrder_message(String order_message) {
        this.order_message = order_message;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", user=" + user +
                ", orderstate=" + orderstate +
                ", order_num=" + order_num +
                ", order_price=" + order_price +
                ", order_state=" + order_state +
                ", order_date='" + order_date + '\'' +
                ", order_message='" + order_message + '\'' +
                '}';
    }
}
