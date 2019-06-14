package com.android3.xpy;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;


import com.android3.xpy.entity.Goods;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;


/**
 * @Authur : Yancy
 * @E-mail : 986244073@qq.com
 * @Create : 2019/6/8
 * @Desc :
 */

public class DataLab {
    private Context context;

    public DataLab(Context ctx) {
        context = ctx;
    }

//    public List<Goods> httpGetJson() {
//        List<Goods> result = new ArrayList<>();
//        String url = " https://www.easy-mock.com/mock/5cf2759064873463eb866334/sell/list";
//        OkHttpUtils
//                .get()
//                .url(url)
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//                        Log.d("qqq", "onResponse: " + response);
//                        Gson gson =new Gson();
//                        Goods goodsjson = gson.fromJson(response, Goods.class);
//                        Log.d("qqq", "onResponse: "+goodsjson);
//                    }
//                });
//        return null;
//    }

    public String loadJSONFromAsset(String filename) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(filename);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            Log.e("FFPLAY", ex.getMessage());
            ex.printStackTrace();
        }
        return json;
    }

    public List<Goods> getGoods(String filename) {
        List<Goods> result = new ArrayList<>();
        String json = loadJSONFromAsset(filename);
        try {
            JSONObject obj = new JSONObject(json);
            JSONArray data = obj.getJSONArray("data");
            for (int i = 0; i < data.length(); i++) {
                Goods c = new Goods();
                JSONObject item = data.getJSONObject(i);
                c.setName(item.getString("name"));
                c.setIcon(item.getString("icon"));
                c.setDescription(item.getString("description"));
                c.setPrice(item.getDouble("price"));
                c.setType(item.getString("type"));
                result.add(c);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}
