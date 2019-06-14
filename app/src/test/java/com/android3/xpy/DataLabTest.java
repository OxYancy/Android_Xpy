package com.android3.xpy;

import android.util.Log;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.junit.Test;

import okhttp3.Call;

import static org.junit.Assert.*;

/**
 * @Authur : Yancy
 * @E-mail : 986244073@qq.com
 * @Create : 2019/6/8
 * @Desc :
 */

public class DataLabTest {

    @Test
    public void httpGetJson() {
        String url = "http://localhost:8080/sell/list";
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        System.out.println(e.toString());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        System.out.println(response.toString());
                    }
                });
    }
}