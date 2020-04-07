package com.ssm.entity;

public class Goodstype {
    private int id;//种类编号
    private String typename;//种类名

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "Goodstype{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                '}';
    }
}
