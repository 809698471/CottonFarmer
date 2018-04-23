package com.lianghuawang.cottonfarmer.fragment.myinsurance;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.ExpiredAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 已过期
 */
public class ExpiredFragment extends Fragment {

    private RecyclerView expiredfragment_recy;
    List<Bean> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.expiredfragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        expiredfragment_recy = (RecyclerView) view.findViewById(R.id.expiredfragment_recy);
        expiredfragment_recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        for (int i = 0; i < 10; i++) {
            Bean bean = new Bean();
            bean.setName("棉花价格险：");
            list.add(bean);

        }
//        Bean bean = new Bean();
//        bean.setName("棉花灾害险");
//        list.add(bean);
        //设置Adapter
        ExpiredAdapter adapter = new ExpiredAdapter(list);
        expiredfragment_recy.setAdapter(adapter);
    }
}
