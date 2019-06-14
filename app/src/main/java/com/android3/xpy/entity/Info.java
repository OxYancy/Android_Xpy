package com.android3.xpy.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("group")
    @Expose
    private String group;
    @SerializedName("title")
    @Expose
    private String title;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Info{" +
                "content='" + content + '\'' +
                ", group='" + group + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
