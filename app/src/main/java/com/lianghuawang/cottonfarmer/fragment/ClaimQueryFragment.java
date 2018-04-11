package com.lianghuawang.cottonfarmer.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lianghuawang.cottonfarmer.R;

/**
 *理赔查询
 */
public class ClaimQueryFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.claimqueryfragment, null);
        return view;
    }

}
