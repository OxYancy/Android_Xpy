package com.android3.xpy.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Authur : Yancy
 * @E-mail : 986244073@qq.com
 * @Create : 2019/6/11
 * @Desc :
 */

public class GoodsList {
    @SerializedName("data")
    @Expose
    private List<Goods> data = null;

    public List<Goods> getData() {
        return data;
    }

    public void setData(List<Goods> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GoodsList{" +
                "data=" + data +
                '}';
    }
}
