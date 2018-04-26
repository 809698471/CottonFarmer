package com.lianghuawang.cottonfarmer.activity.message.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.MyHomeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 最新
 */
public class NewestFragment extends Fragment {


    private RecyclerView newst_recycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.newstfragment, null);
        initView(view);
        Log.e("--------------", "++++++++++" );
        return view;
    }

    private void initView(View view) {
        newst_recycler = (RecyclerView) view.findViewById(R.id.newst_recy);

        newst_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Bean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Bean bean = new Bean();
            bean.setName("棉花险");
            list.add(bean);

        }
//        Bean bean = new Bean();
//        bean.setName("棉花险");
//        list.add(bean);
        //设置Adapter
        MyHomeAdapter adapter = new MyHomeAdapter(getContext(),list);
        newst_recycler.setAdapter(adapter);
    }
}
