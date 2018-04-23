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
import com.lianghuawang.cottonfarmer.adapter.GuaranteeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 保障中
 */
public class GuaranteeFragment extends Fragment {
    List<Bean> list = new ArrayList<>();
    private RecyclerView guaranteefragment_recy;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.guaranteefragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        guaranteefragment_recy = (RecyclerView) view.findViewById(R.id.guaranteefragment_recy);
        guaranteefragment_recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        for (int i = 0; i < 10; i++) {
            Bean bean = new Bean();
            bean.setName("棉花收入险：");
            list.add(bean);

        }
//        Bean bean = new Bean();
//        bean.setName("棉花灾害险");
//        list.add(bean);
        //设置Adapter
        GuaranteeAdapter adapter = new GuaranteeAdapter(getActivity(),list);
        guaranteefragment_recy.setAdapter(adapter);
    }

}
