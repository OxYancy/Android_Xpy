package com.android3.xpy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.android3.xpy.entity.Goods;
import com.android3.xpy.entity.GoodsList;
import com.android3.xpy.fragment.CarFragment;
import com.android3.xpy.fragment.HomeFragment;
import com.android3.xpy.fragment.MyFragment;
import com.android3.xpy.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;


public class MainActivity extends AppCompatActivity {
    ArrayList<Fragment> fragments;
    private BottomNavigationView bottomNavigationView;
    private Banner banner;
    private List<Integer> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
//        banner = findViewById(R.id.banner);
//        images.add(R.drawable.banner1);
//        images.add(R.drawable.banner2);
//        images.add(R.drawable.banner3);
////        banner.setImageLoader(new GlideImageLoader());
//        banner.setBannerAnimation(Transformer.DepthPage);
//
////        banner.setImageLoader(new GlideImageLoader(this,));
//        banner.setImages(images);
//        banner.start();


        fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance());
        fragments.add(SearchFragment.newInstance());
        fragments.add(CarFragment.newInstance());
        fragments.add(MyFragment.newInstance());

        final FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.fragment_container, fragments.get(0), "HOME")
                .add(R.id.fragment_container, fragments.get(1), "SEARCH")
                .add(R.id.fragment_container, fragments.get(2), "CAR")
                .add(R.id.fragment_container, fragments.get(3), "MY")
                .commit();
        fm.beginTransaction()
                .hide(fragments.get(1))
                .hide(fragments.get(2))
                .hide(fragments.get(3))
                .commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab_home:
                        fm.beginTransaction()
                                .hide(fragments.get(1))
                                .hide(fragments.get(2))
                                .hide(fragments.get(3))
                                .show(fragments.get(0))
                                .commit();
                        return true;
                    case R.id.tab_search:
                        fm.beginTransaction()
                                .hide(fragments.get(0))
                                .hide(fragments.get(2))
                                .hide(fragments.get(3))
                                .show(fragments.get(1))
                                .commit();
                        return true;
                    case R.id.tab_car:
                        fm.beginTransaction()
                                .hide(fragments.get(0))
                                .hide(fragments.get(1))
                                .hide(fragments.get(3))
                                .show(fragments.get(2))
                                .commit();
                        return true;
                    case R.id.tab_my:
                        fm.beginTransaction()
                                .hide(fragments.get(0))
                                .hide(fragments.get(2))
                                .hide(fragments.get(1))
                                .show(fragments.get(3))
                                .commit();
                        return true;
                }
                return false;
            }
        });
    }



}