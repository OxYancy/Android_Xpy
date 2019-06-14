package com.android3.xpy.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android3.xpy.R;

import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.SearchView;
import scut.carson_ho.searchview.bCallBack;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    private SearchView searchView;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search,container, false);
        searchView= view.findViewById(R.id.search_view);

        searchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {
                System.out.println("我收到了" + string);
            }
        });

        searchView.setOnClickBack(new bCallBack() {
            @Override
            public void BackAciton() {
                System.out.println("back");
            }
        });        TextView textView = new TextView(getActivity());


        textView.setText("搜索");
        return view;
    }

    public static SearchFragment newInstance() {

        return new SearchFragment();
    }
}
