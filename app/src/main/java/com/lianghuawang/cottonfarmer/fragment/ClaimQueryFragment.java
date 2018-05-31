package com.lianghuawang.cottonfarmer.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.my.ClaimProgressActivity;

/**
 * 理赔查询
 */
public class ClaimQueryFragment extends Fragment implements View.OnClickListener {


    private ImageView claimqueryfragment_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.claimqueryfragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        claimqueryfragment_btn = (ImageView) view.findViewById(R.id.claimqueryfragment_img);

        claimqueryfragment_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //理赔进度
            case R.id.claimqueryfragment_img:
                startActivity(new Intent(getActivity(), ClaimProgressActivity.class));
                break;
        }
    }
}
