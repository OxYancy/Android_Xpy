package com.android3.xpy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android3.xpy.R;
import com.android3.xpy.entity.Goods;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.rxjava.rxlife.RxLife;

import rxhttp.wrapper.param.RxHttp;

public class SellActivity extends AppCompatActivity {
    private TextInputEditText goods_name;
    private TextInputEditText goods_price;
    private TextInputEditText goods_desc;
    private TextInputEditText goode_icon;
    private TextInputEditText goode_type;
    private MaterialButton btn_sell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        goods_name = findViewById(R.id.goods_name);
        goods_price = findViewById(R.id.goods_price);
        goods_desc = findViewById(R.id.goods_desc);
        goode_icon = findViewById(R.id.goods_icon);
        btn_sell = findViewById(R.id.sell);
        goode_type = findViewById(R.id.goods_type);

        btn_sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = goods_name.getText().toString().trim();
                String price = goods_price.getText().toString().trim();
                String desc = goods_desc.getText().toString().trim();
                String type = goode_type.getText().toString().trim();
                String icon = goode_icon.getText().toString().trim();
                String url = "http://39.105.14.128:8080/add?name=" + name + "&price=" + price + "&description=" + desc + "&icon=" + icon+"&type="+type;
                RxHttp.get(url).asObject(Goods.class).as(RxLife.asOnMain(SellActivity.this))
                        .subscribe(s -> {
                            Log.d("q", "onClick: "+s.toString());
                            Toast.makeText(SellActivity.this, "发布成功"+name, Toast.LENGTH_SHORT).show();
                        }, throwable -> {
                            Log.d("q", "onClick: "+throwable);
                        });

            }
        });
    }
}
