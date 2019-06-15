package com.android3.xpy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.android3.xpy.R;
import com.android3.xpy.entity.User;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.rxjava.rxlife.RxLife;

import rxhttp.wrapper.param.RxHttp;

public class SignActivity extends AppCompatActivity {
    private TextInputEditText userName;
    private TextInputEditText passWord;
    private MaterialButton signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        userName = findViewById(R.id.sign_userName);
        passWord = findViewById(R.id.sign_passWord);
        signUp = findViewById(R.id.login);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString().trim();
                String pass = passWord.getText().toString().trim();
                if (TextUtils.isEmpty(name) | TextUtils.isEmpty(pass)) {
                    Toast.makeText(SignActivity.this, "请输入账号 or 密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                String url = "http://139.155.116.93:8080/login/?name=" + name + "&password=" + pass;
                RxHttp.get(url)
                        .asObject(User.class)
                        .as(RxLife.asOnMain(SignActivity.this))
                        .subscribe(s -> {
                            Toast.makeText(SignActivity.this, "注册成功" + name, Toast.LENGTH_SHORT).show();
                        }, throwable -> {
                            Toast.makeText(SignActivity.this, "失败"+throwable, Toast.LENGTH_SHORT).show();
                        });
            }
        });
    }


}
