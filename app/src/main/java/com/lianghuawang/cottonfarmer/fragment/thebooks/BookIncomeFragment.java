package com.lianghuawang.cottonfarmer.fragment.thebooks;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.BookIncomeFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 账本收入
 */
public class BookIncomeFragment extends Fragment {

private List<Bean> list;
    private RecyclerView bookincomefragment_recy;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.bookincomefragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        bookincomefragment_recy = (RecyclerView) view.findViewById(R.id.bookincomefragment_recy);
        bookincomefragment_recy.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        Bean  bean = new Bean();
        bean.setName("-500");
        list.add(bean);
       BookIncomeFragmentAdapter bookIncomeFragmentAdapter = new BookIncomeFragmentAdapter(list);
        bookincomefragment_recy.setAdapter(bookIncomeFragmentAdapter);
    }
}
