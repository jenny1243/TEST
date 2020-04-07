package com.ssm.entity;

public class Goodstate {
    private int id;
    private String state;//商品状态  上架 审核未通过 下架  已审核

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Goodstate{" +
                "id=" + id +
                ", state='" + state + '\'' +
                '}';
    }
}
