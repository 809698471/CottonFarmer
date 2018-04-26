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
import com.lianghuawang.cottonfarmer.adapter.FormulaAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 公式
 */
public class FormulaFragment extends Fragment {

    private RecyclerView formulafragment_recy;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.formulafragment, null);
        Log.e("+++++++++++++", "++++++++++" );
        initView(view);
        return view;
    }

    private void initView(View view) {
        formulafragment_recy = (RecyclerView) view.findViewById(R.id.formulafragment_recy);
        formulafragment_recy.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Bean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Bean bean = new Bean();
            bean.setName("<<点击查看具体详情");
            list.add(bean);

        }
//        Bean bean = new Bean();
//        bean.setName("棉花险");
//        list.add(bean);
        //设置Adapter
        FormulaAdapter adapter = new FormulaAdapter(getContext(),list);
        formulafragment_recy.setAdapter(adapter);
    }
}
