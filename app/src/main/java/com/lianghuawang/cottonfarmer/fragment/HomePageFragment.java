package com.lianghuawang.cottonfarmer.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;

/**
 * 首页
 */
public class HomePageFragment extends Fragment {

 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment1);
        return textView;
    }

}
