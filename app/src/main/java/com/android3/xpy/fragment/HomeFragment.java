package com.android3.xpy.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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


import java.util.ArrayList;
import java.util.List;

import rxhttp.wrapper.param.RxHttp;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private List<Integer> images = new ArrayList<>();
    private GoodsListAdapter listAdapter;
    private Banner banner;
    private RecyclerView shopList;
    private List<Goods> data;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = httpGetJson();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        initData();

        data = httpGetJson();

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        banner = view.findViewById(R.id.banner);
        shopList = view.findViewById(R.id.shopList);
        Log.d("QQQQQ", "onCreateView: "+data);
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
                    Toast.makeText(getActivity(), "点击失败", Toast.LENGTH_SHORT);
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

//    private void initData() {
////        DataLab lab = new DataLab(getContext());
////        this.data = lab.getGoods("data.json");
//        this.data = httpGetJson();
//    }

    public static HomeFragment newInstance() {

        return new HomeFragment();
    }

    public List<Goods> httpGetJson() {
        List<Goods> goods = new ArrayList<>();
        new Thread() {
            @Override
            public void run() {
        String url = "https://www.easy-mock.com/mock/5cf2759064873463eb866334/sell/lists";
        RxHttp.get(url)
                .asString()
                .subscribe(s -> {
                    Gson gson = new Gson();
                    GoodsList goodsList = gson.fromJson(s, GoodsList.class);
                    goods.addAll(goodsList.getData());
                    Log.d("QQ", "run: " + goods.toString());

                }, throwable -> {
                    Toast.makeText(getActivity(), "" + throwable, Toast.LENGTH_SHORT).show();
                });
            }
        }.start();

        return goods;
    }
}
