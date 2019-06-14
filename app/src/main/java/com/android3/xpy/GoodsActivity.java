package com.android3.xpy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android3.xpy.entity.Goods;
import com.bumptech.glide.Glide;

public class GoodsActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView tv_price;
    private TextView tv_name;
    private TextView tv_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        imageView = findViewById(R.id.image);
        tv_name = findViewById(R.id.name);
        tv_price = findViewById(R.id.price);
        tv_desc = findViewById(R.id.desc);


        Goods goods = (Goods) getIntent().getSerializableExtra("goods");
        tv_name.setText(goods.getName().toString().trim());
        tv_price.setText(goods.getPrice().toString().trim());
        tv_desc.setText(goods.getDescription().toString().trim());
        Glide.with(getApplicationContext()).load(goods.getIcon().toString()).into(imageView);

    }
}
