package com.android3.xpy.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android3.xpy.R;
import com.android3.xpy.activity.LoginActivity;
import com.android3.xpy.activity.SellActivity;
import com.android3.xpy.entity.User;
import com.google.android.material.button.MaterialButton;
import com.leon.lib.settingview.LSettingItem;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link MyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyFragment extends Fragment {
    private TextView myUserName;
    private MaterialButton logOut;
    private LSettingItem mSell;

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        myUserName = view.findViewById(R.id.my_username);
        logOut = view.findViewById(R.id.logOut);
        mSell = view.findViewById(R.id.item_mySell);

        mSell.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click(boolean isChecked) {
                Intent intent = new Intent(getActivity(), SellActivity.class);
                startActivity(intent);
            }
        });

        SharedPreferences sp = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        myUserName.setText(sp.getString("name", ""));

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                SharedPreferences.Editor edit = sp.edit();
                edit.putString("name", "");
                edit.putString("password", "");
                edit.apply();
                startActivity(intent);
            }
        });
        return view;
    }


    public static MyFragment newInstance() {

        return new MyFragment();
    }
}
