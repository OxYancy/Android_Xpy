package com.android3.xpy.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android3.xpy.GlideImageLoader;
import com.android3.xpy.R;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private List<Integer> images = new ArrayList<>();
    private Banner banner;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        banner = view.findViewById(R.id.banner);

        TextView textView = new TextView(getActivity());
        textView.setText("home");

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

    public static HomeFragment newInstance() {

        return new HomeFragment();
    }
}
