package com.android3.xpy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;

import com.android3.xpy.R;
import com.android3.xpy.entity.User;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                    Intent intent = new Intent(LaunchActivity.this, LoginActivity.class);

                    SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
                    String name = sp.getString("name", "");
                    String password = sp.getString("password", "");
                    if (!(TextUtils.isEmpty(name) && TextUtils.isEmpty(password))) {
                        User user = new User();
                        user.setName(name);
                        user.setPassword(password);
                        intent = new Intent(LaunchActivity.this, MainActivity.class);
                        intent.putExtra("user", user);
                        startActivity(intent);

                    }

                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
