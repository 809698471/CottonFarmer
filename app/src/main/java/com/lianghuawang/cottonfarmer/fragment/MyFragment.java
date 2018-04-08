package com.lianghuawang.cottonfarmer.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lianghuawang.cottonfarmer.R;

/**
 * 我的
 */
public class MyFragment extends Fragment {



    private LinearLayout myfragment_bankcard;
    private LinearLayout myfragment_thebooks;
    private LinearLayout myfragment_order;
    private LinearLayout myfragment_insurance;
    private LinearLayout myfragment_compensation;
    private LinearLayout myfragment_credit;
    private LinearLayout myfragment_loan;
    private LinearLayout myfragment_setup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.myfragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {

        myfragment_bankcard = (LinearLayout) view.findViewById(R.id.myfragment_bankcard);
        myfragment_thebooks = (LinearLayout) view.findViewById(R.id.myfragment_thebooks);
        myfragment_order = (LinearLayout) view.findViewById(R.id.myfragment_order);
        myfragment_insurance = (LinearLayout) view.findViewById(R.id.myfragment_insurance);
        myfragment_compensation = (LinearLayout) view.findViewById(R.id.myfragment_compensation);
        myfragment_credit = (LinearLayout) view.findViewById(R.id.myfragment_credit);
        myfragment_loan = (LinearLayout) view.findViewById(R.id.myfragment_loan);
        myfragment_setup = (LinearLayout) view.findViewById(R.id.myfragment_setup);
    }
}
