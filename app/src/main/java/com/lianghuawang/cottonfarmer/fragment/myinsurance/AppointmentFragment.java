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
import com.lianghuawang.cottonfarmer.adapter.AppointmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 预约中
 */
public class AppointmentFragment extends Fragment {


    private RecyclerView appointmentfragment_recy;
    List<Bean> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.appointmentfragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        appointmentfragment_recy = (RecyclerView) view.findViewById(R.id.appointmentfragment_recy);
        appointmentfragment_recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        for (int i = 0; i < 10; i++) {
            Bean bean = new Bean();
            bean.setName("棉花灾害险：");
            list.add(bean);

        }
//        Bean bean = new Bean();
//        bean.setName("棉花灾害险");
//        list.add(bean);
        //设置Adapter
        AppointmentAdapter adapter = new AppointmentAdapter(getActivity(),list);
        appointmentfragment_recy.setAdapter(adapter);
    }

}
