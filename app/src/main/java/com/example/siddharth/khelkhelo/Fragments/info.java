package com.example.siddharth.khelkhelo.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.siddharth.khelkhelo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class info extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Context context;
    public TextView textView,textView2,textView3,textView4,textView5,textView6,textView7,
            t8,t9,t10,t11,t12,t13,t14,t15,t16,t18,t17,t19,t20;






    // TODO: Rename and change types and number of parameters
    public static info newInstance() {
        info fragment = new info();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_info, container, false);        // Inflate the layout for this fragment

        return view;

    }


    }
