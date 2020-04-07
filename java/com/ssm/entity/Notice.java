package com.ssm.entity;

public class Notice {
    private int id;
    private String content;//发布的公告内容
    private String publis_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublis_time() {
        return publis_time;
    }

    public void setPublis_time(String publis_time) {
        this.publis_time = publis_time;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", pub_time='" + publis_time + '\'' +
                '}';
    }
}
