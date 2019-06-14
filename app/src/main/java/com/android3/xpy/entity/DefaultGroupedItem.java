package com.android3.xpy.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DefaultGroupedItem {
    @SerializedName("header")
    @Expose
    private String header;
    @SerializedName("isHeader")
    @Expose
    private Boolean isHeader;
    @SerializedName("info")
    @Expose
    private Info info;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Boolean getIsHeader() {
        return isHeader;
    }

    public void setIsHeader(Boolean isHeader) {
        this.isHeader = isHeader;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "DefaultGroupedItem{" +
                "header='" + header + '\'' +
                ", isHeader=" + isHeader +
                ", info=" + info +
                '}';
    }
}
