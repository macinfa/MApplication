package com.example.hasee.myapplication.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hasee.myapplication.R;
import com.example.hasee.myapplication.ui.QQHealthView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NO4Fragment extends Fragment {

    private QQHealthView qq;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_no4, container, false);
        qq= (QQHealthView)view.findViewById(R.id.qq);
        qq=new QQHealthView(getActivity(),null,0);
        qq.setSteps(new int[]{10050, 15280, 8900, 9200, 6500, 5660, 7450});
        return inflater.inflate(R.layout.fragment_no4, container, false);
    }

}
