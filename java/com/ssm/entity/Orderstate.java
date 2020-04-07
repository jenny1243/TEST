package com.ssm.entity;

public class Orderstate {
    private int id;
    private String state;//状态

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
        return "Orderstate{" +
                "id=" + id +
                ", state='" + state + '\'' +
                '}';
    }
}
