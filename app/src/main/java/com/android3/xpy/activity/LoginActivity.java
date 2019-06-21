package com.android3.xpy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android3.xpy.R;
import com.android3.xpy.entity.User;
import com.android3.xpy.fragment.HomeFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.rxjava.rxlife.RxLife;

import java.util.concurrent.atomic.AtomicReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import rxhttp.wrapper.param.RxHttp;

public class LoginActivity extends AppCompatActivity {
    final String TAG = "Login";
    @BindView(R.id.userName)
     TextInputEditText userName;
    @BindView(R.id.passWord)
     TextInputEditText passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
//        userName = findViewById(R.id.userName);
//        passWord = findViewById(R.id.passWord);


    }

    public void login(View view) {
        String name = userName.getText().toString().trim();
        String password = passWord.getText().toString().trim();
//        String url = "http://139.155.116.93:8080/login/" + name;
        if (TextUtils.isEmpty(name) | TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入账号 or 密码", Toast.LENGTH_SHORT).show();
            return;
        }
//        String url = "https://www.easy-mock.com/mock/5cf2759064873463eb866334/sell/login";
        String url = "http://39.105.14.128:8080/login/" + name;
        RxHttp.get(url)
//                .asString()
                .asObject(User.class)
                .as(RxLife.asOnMain(this))
                .subscribe(s -> {
                    if (s.getName().equals(name) && s.getPassword().equals(password)) {
                        Toast.makeText(LoginActivity.this, "登陆成功!" + name, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("user", s);
                        SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
                        SharedPreferences.Editor edit = sp.edit();
                        edit.putString("name", s.getName());
                        edit.putString("password", s.getPassword());
                        edit.apply();
                        startActivity(intent);
                        finish();
                    }
                    Log.d(TAG, "login: " + s.toString());
                }, throwable -> {
                    Toast.makeText(this, "登陆失败~" + throwable, Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "login: " + throwable);

                });

    }

    public void sign(View view) {
        Intent intent1 = new Intent(LoginActivity.this, SignActivity.class);
        startActivity(intent1);
    }
}
