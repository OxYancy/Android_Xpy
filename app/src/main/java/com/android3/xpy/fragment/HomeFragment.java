package com.android3.xpy.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android3.xpy.DataLab;
import com.android3.xpy.GlideImageLoader;
import com.android3.xpy.GoodClickListenner;
import com.android3.xpy.GoodsActivity;
import com.android3.xpy.GoodsListAdapter;
import com.android3.xpy.MainActivity;
import com.android3.xpy.R;
import com.android3.xpy.entity.Goods;
import com.android3.xpy.entity.GoodsList;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private List<Integer> images = new ArrayList<>();
    //    private  List<Goods> goods;
    private GoodsListAdapter listAdapter;
    private Banner banner;
    private RecyclerView shopList;
    private List<Goods> data;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initData();
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        banner = view.findViewById(R.id.banner);
        shopList = view.findViewById(R.id.shopList);
        Toast.makeText(getActivity(), "无效的频道", Toast.LENGTH_SHORT).show();
        Log.d("qq", "onCreateView: " + data.toString());
        TextView textView = new TextView(getActivity());
        textView.setText("home");

        listAdapter = new GoodsListAdapter(data, new GoodClickListenner() {
            @Override
            public void onClick(View v, int position) {
                Log.i("FFPLAY", "Clicked " + view + " on " + position);
//                Intent intent = new Intent(getActivity(), GoodsActivity.class);
//                intent.putExtra("goods", data.get(position));
                if (position < data.size()) {
                    Goods good = data.get(position);
                    Intent intent = new Intent(getActivity(), GoodsActivity.class);
                    intent.putExtra("goods", data.get(position));
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), "无效的频道", Toast.LENGTH_SHORT);
                }
            }
        });

        shopList.setAdapter(listAdapter);

        shopList.setLayoutManager(new LinearLayoutManager(getActivity()));
        images.add(R.drawable.banner1);
        images.add(R.drawable.banner2);
        images.add(R.drawable.banner3);
        banner.setImageLoader(new GlideImageLoader());
        banner.setBannerAnimation(Transformer.DepthPage);

//        banner.setImageLoader(new GlideImageLoader(this,));
        banner.setImages(images);
        banner.start();
        return view;
    }

    private void initData() {
        DataLab lab = new DataLab(getContext());
        this.data = lab.getGoods("data.json");
    }

    public static HomeFragment newInstance() {

        return new HomeFragment();
    }

//    public void httpGetJson() {
////        List<Goods> goodList = new ArrayList<>();
//        new Thread() {
//            @Override
//            public void run() {
//                String url = "https://www.easy-mock.com/mock/5cf2759064873463eb866334/sell/lists";
//                OkHttpUtils
//                        .get()
//                        .url(url)
//                        .build()
//                        .execute(new StringCallback() {
//                            @Override
//                            public void onError(Call call, Exception e, int id) {
//                                Log.d("qqq", "e: " + e);
//                            }
//
//                            @Override
//                            public void onResponse(String response, int id) {
//
////                        Log.d("qqq", "onResponse: " + response);
//                                Gson gson = new Gson();
//                                GoodsList goodsList = gson.fromJson(response, GoodsList.class);
//                                Log.d("qqq", "onResponse: " + goodsList.getData());
//                                data.addAll(goodsList.getData());
//                                Log.d("qqq", "onResponse: " + data.toString());
//                            }
//                        });
////        Log.d("QQ", "httpGetJson: "+goodList.toString());
//            }
//        }.start();
//
//    }
}
